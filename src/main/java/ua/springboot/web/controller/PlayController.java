package ua.springboot.web.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
		model.addAttribute("play", entity);
		return "play/play-profile";
	}
	
	@GetMapping("/list")
	public String showPlayList(Model model) {
		model.addAttribute("playList", playService.findAllPlays());
		return "play/play-list";
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
		return "redirect:/play/list";
	}
	
	@GetMapping("edit/{playId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showPlayEdingForm(@PathVariable("playId") int playId, Model model) {
		ThePlay entity = playService.findById(playId);
		Set<Actor> actorsSet = new HashSet<>(actorService.findAllActors());
		EditPlayRequest request = PlayMapper.entityToEditPlay(entity);
		
		model.addAttribute("actorList", actorsSet);
		model.addAttribute("genres", Genre.values());
		model.addAttribute("editPlay", request);
		return "play/edit-play";
	}
	
	@PostMapping("edit/{playId}")
	public String editPlay(@ModelAttribute("editPlay") EditPlayRequest request,
			               @PathVariable("playId") int playId) throws IOException {
		
		ThePlay play = PlayMapper.editPlayToEntity(request);
		playService.save(play);
		
		CustomFileUtils.createFolder("play_" + play.getId());
		CustomFileUtils.createImage("play_" + play.getId(), request.getPlayImage());
		return "redirect:/play/list";
	}

}
