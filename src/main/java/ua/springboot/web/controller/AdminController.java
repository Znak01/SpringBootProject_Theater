package ua.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.springboot.web.service.ActorService;
import ua.springboot.web.service.PlayService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private ActorService actorService;
	private PlayService playService;
	
	
	@Autowired
	public AdminController(ActorService actorService, PlayService playService) {
		super();
		this.actorService = actorService;
		this.playService = playService;
	}



	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showAdminBoard(Model model) {
		model.addAttribute("actorList", actorService.findAllActors());
		model.addAttribute("playList", playService.findAllPlays());
		return "/admin/board";
	}
	
}
