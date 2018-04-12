package ua.springboot.web.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.springboot.web.domain.ActorFilter;
import ua.springboot.web.domain.ActorRequest;
import ua.springboot.web.domain.EditActorRequest;
import ua.springboot.web.entity.Actor;
import ua.springboot.web.entity.enumeration.Gender;
import ua.springboot.web.mapper.ActorMapper;
import ua.springboot.web.service.ActorService;
import ua.springboot.web.service.utils.CustomFileUtils;


@Controller
@RequestMapping("/actor")
@SessionAttributes("editActor")
public class ActorController {

	@Autowired
	private ActorService actorService;
	
	@GetMapping("/{actorId}")
	public String showActorProf(@PathVariable("actorId") int id, Model model) throws IOException {
		
		Actor entity = actorService.findById(id);
		
		if(entity == null) return "redirect:/";
		
		model.addAttribute("actorImageSrc", CustomFileUtils.getImage("actor_" + entity.getId(), entity.getActorImage()));
		model.addAttribute("playList", entity.getPlays());
		model.addAttribute("actor", entity);
		return "actor/actor-profile";
	}
	
	@GetMapping("/list/pages")
	public String showActorList(Model model, @PageableDefault Pageable pageable) throws IOException {
		Page<Actor> page = actorService.findAllActorsByPage(pageable);
		
		for(int i = 0; i < page.getContent().size(); i++) {
            String imageName = page.getContent().get(i).getActorImage();
            
            page.getContent().get(i).setActorImage(CustomFileUtils.getImage("actor_" + page.getContent().get(i).getId(), imageName)); 
        }
		
        int currentPage = page.getNumber();
        int begin = Math.max(1, currentPage - 2);
        int end = Math.min(begin + 2, page.getNumber());
        
        
		model.addAttribute("actorList", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);
		model.addAttribute("perPage", page.getSize());
		model.addAttribute("actorListByPageSize", page.getContent());
		
		
		return "actor/actor-page";
	}
	
	@GetMapping("/list/pages/filter")
	public String showActorListFilter(Model model, @PageableDefault Pageable pageable, 
			                                 @RequestParam("search") String search) throws IOException {
		ActorFilter filter = null;
		if(search != null) {
			filter = new ActorFilter(search);
		}
		Page<Actor> page = actorService.findAllActorsByFullName(pageable, filter);
		
		for(int i = 0; i < page.getContent().size(); i++) {
            String imageName = page.getContent().get(i).getActorImage();
            
            page.getContent().get(i).setActorImage(CustomFileUtils.getImage("actor_" + page.getContent().get(i).getId(), imageName)); 
        }
		
        int currentPage = page.getNumber();
        int begin = Math.max(1, currentPage - 2);
        int end = Math.min(begin + 2, page.getNumber());
        
        
		model.addAttribute("actorList", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);
		model.addAttribute("perPage", page.getSize());
		model.addAttribute("actorListByPageSize", page.getContent());
		
		
		return "actor/actor-page";
	}
	
	@GetMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showAddActorForm(Model model) {
		model.addAttribute("gender", Gender.values());
		model.addAttribute("actor", new ActorRequest());
		return "actor/add-actor";
	}
	
	@PostMapping("/add")
	public String saveActor(@ModelAttribute("actor") @Valid ActorRequest request, BindingResult result) throws IOException {
		
		if(result.hasErrors()) {
			return "actor/add-actor";
		}
		if(request.getActorImage().isEmpty()) {
			return "redirect:/actor/add";
		}
		Actor entity = ActorMapper.toActor(request);
		
		actorService.save(entity);
		CustomFileUtils.createFolder("actor_" + entity.getId());
		CustomFileUtils.createImage("actor_" + entity.getId(), request.getActorImage());
		return "redirect:/actor/list/pages";
	}
	
	@GetMapping("/edit/{actorId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showActorEdingForm(@PathVariable("actorId") int actorId, Model model) {
		Actor actor = actorService.findById(actorId);
		EditActorRequest request = ActorMapper.entityToEditActor(actor);
		
		model.addAttribute("gender", Gender.values());
		model.addAttribute("editActor", request);
		return "actor/edit-actor";
	}
	
	@PostMapping("/edit/{actorId}")
	public String editActor(@ModelAttribute("editActor") @Valid EditActorRequest request, 
			                @PathVariable("actorId") int actorId, BindingResult result) throws IOException {
		
		if(result.hasErrors()) {
			return "actor/edit-actor";
		}
		
		if(request.getActorImage().isEmpty()) {
			return "redirect:/actor/edit/" + actorId;
		}
		Actor actor = ActorMapper.editRequestToActor(request);
		actorService.save(actor);
		
		CustomFileUtils.createFolder("actor_" + actor.getId());
		CustomFileUtils.createImage("actor_" + actor.getId(), request.getActorImage());
		return "redirect:/actor/list/pages";
	}
	
	@GetMapping("/delete/{actorId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteActor(@PathVariable("actorId") int actorId) {
		actorService.deleteActorById(actorId);
		return "redirect:/admin";
	}
	
}
