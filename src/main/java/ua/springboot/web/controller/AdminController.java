package ua.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.springboot.web.service.ActorService;
import ua.springboot.web.service.PlayService;
import ua.springboot.web.service.SessionService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private ActorService actorService;
	private PlayService playService;
	private SessionService sessionService;
	
	
	@Autowired
	public AdminController(ActorService actorService, PlayService playService, SessionService sessionService) {
		super();
		this.actorService = actorService;
		this.playService = playService;
		this.sessionService = sessionService;
	}



	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showAdminBoard(Model model) {
		model.addAttribute("actorList", actorService.findAllActors());
		model.addAttribute("playList", playService.findAllPlays());
		model.addAttribute("sessionList", sessionService.findAllSessions());
		return "/admin/board";
	}
	
}
