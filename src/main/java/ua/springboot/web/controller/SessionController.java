package ua.springboot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.springboot.web.domain.SessionRequest;
import ua.springboot.web.entity.Session;
import ua.springboot.web.entity.ThePlay;
import ua.springboot.web.mapper.SessionMapper;
import ua.springboot.web.service.PlayService;
import ua.springboot.web.service.SessionService;

@Controller
@RequestMapping("/session")
public class SessionController {

	private SessionService sessionService;
	private PlayService playService;
	
	
	@Autowired
	public SessionController(SessionService sessionService, PlayService playService) {
		super();
		this.sessionService = sessionService;
		this.playService = playService;
	}


	@GetMapping("/list")
	public String showSessionList(Model model) {
		model.addAttribute("sessionList", sessionService.findAllSessions());
		return "session/session-list";
	}

	@GetMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addSession( Model model) {
		model.addAttribute("playList", playService.findAllPlays());
		model.addAttribute("session", new SessionRequest());
		return "session/add-session";
		
	}
	
	@PostMapping("/add")
	public String saveSession(@ModelAttribute("session") @Valid SessionRequest request, 
			@PathVariable("play") ThePlay play,
			                  BindingResult result) {
		
		if(result.hasErrors()) {
			return "session/add-session";
		}
		Session session = new Session();
		session.getPlays().add(play);
		session = SessionMapper.toSession(request);
		sessionService.save(session);
		return "redirect:/session/list";
	}
	
	
	
}
