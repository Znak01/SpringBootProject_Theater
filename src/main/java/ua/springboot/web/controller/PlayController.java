package ua.springboot.web.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.springboot.web.domain.EditPlayRequest;
import ua.springboot.web.domain.PlayRequest;
import ua.springboot.web.entity.Actor;
import ua.springboot.web.entity.ThePlay;
import ua.springboot.web.entity.enumeration.Genre;
import ua.springboot.web.mapper.PlayMapper;
import ua.springboot.web.service.ActorService;
import ua.springboot.web.service.PlayService;
import ua.springboot.web.service.utils.CustomFileUtils;

@Component
@RequestMapping("/play")
@SessionAttributes("editPlay")
public class PlayController {
	
	
	private PlayService playService;
	private ActorService actorService;
	
	
	@Autowired
	public PlayController(PlayService playService, ActorService actorService) {
		this.playService = playService;
		this.actorService = actorService;
	}

	@GetMapping("/{playId}")
	public String showPlayProf(@PathVariable("playId") int id, Model model) throws IOException {
		
		ThePlay entity = playService.findById(id);
		
		if(entity == null) return "redirect:/";
		
		model.addAttribute("playImageSrc", CustomFileUtils.getImage("play_" + entity.getId(), entity.getPlayImage()));
		model.addAttribute("actorList", entity.getActors());
		model.addAttribute("play", entity);
		return "play/play-profile";
	}
	
	@GetMapping("/list/pages")
	public String showPlayList(Model model, @PageableDefault Pageable pageable) throws IOException {
		Page<ThePlay> page = playService.findAllPlaysByPage(pageable);
		for(int i = 0; i < page.getContent().size(); i++) {
            String imageName = page.getContent().get(i).getPlayImage();
            
            page.getContent().get(i).setPlayImage(CustomFileUtils.getImage("play_" + page.getContent().get(i).getId(), imageName)); 
        }
		
        int currentPage = page.getNumber();
        int begin = Math.max(1, currentPage - 2);
        int end = Math.min(begin + 2, page.getNumber());
        
        
		model.addAttribute("playList", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);
		model.addAttribute("perPage", page.getSize());
		model.addAttribute("playListByPageSize", page.getContent());
		return "play/play-page";
	}
	
	@GetMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showAddPlayForm(Model model) {
		model.addAttribute("genres", Genre.values());
		model.addAttribute("play", new PlayRequest());
		return "play/add-play";
	}
	
	@PostMapping("/add")
	public String savePlay(@ModelAttribute("play") @Valid PlayRequest request, BindingResult result) {
		
		if(result.hasErrors()) {
			return "play/add-play";
		}
		ThePlay entity = PlayMapper.toPlay(request);
		
		playService.save(entity);
		return "redirect:/play/list/pages";
	}
	
	@GetMapping("edit/{playId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showPlayEdingForm(@PathVariable("playId") int playId, Model model) {
		ThePlay entity = playService.findById(playId);
		EditPlayRequest request = PlayMapper.entityToEditPlay(entity);
		Set<Actor> setActor = new HashSet<>(actorService.findAllActors());
		
		model.addAttribute("actorList", setActor);
		model.addAttribute("genres", Genre.values());
		model.addAttribute("editPlay", request);
		return "play/edit-play";
	}
	
	@PostMapping("edit/{playId}")
	public String editPlay(@ModelAttribute("editPlay")  EditPlayRequest request,
			               @PathVariable("playId") int playId, BindingResult result) throws IOException {
		
		
		
		if(request.getPlayImage().isEmpty()) {
			return "redirect:/play/edit/" + playId;
		}
		
		ThePlay play = PlayMapper.editPlayToEntity(request);
		playService.save(play);
		
		CustomFileUtils.createFolder("play_" + play.getId());
		CustomFileUtils.createImage("play_" + play.getId(), request.getPlayImage());
		return "redirect:/play/list/pages";
	}
	
	@GetMapping("/delete/{playId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deletePlay(@PathVariable("playId") int playId) {
		playService.deletePlayById(playId);
		return "redirect:/admin";
	}

}
