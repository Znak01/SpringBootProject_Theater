package ua.springboot.web.controller;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.springboot.web.domain.EditSessionRequest;
import ua.springboot.web.domain.SessionRequest;
import ua.springboot.web.entity.Session;
import ua.springboot.web.entity.ThePlay;
import ua.springboot.web.mapper.SessionMapper;
import ua.springboot.web.service.PlayService;
import ua.springboot.web.service.SessionService;
import ua.springboot.web.service.TicketService;
import ua.springboot.web.service.utils.CustomFileUtils;

@Controller
@RequestMapping("/session")
@SessionAttributes({"editSession", "editVisitor"})
public class SessionController {

	private SessionService sessionService;
	private PlayService playService;
	private TicketService ticketService;
//	private VisitorService visitorService;
	
	
	@Autowired
	public SessionController(SessionService sessionService, PlayService playService, TicketService ticketService) {
		super();
		this.sessionService = sessionService;
		this.playService = playService;
		this.ticketService = ticketService;
//		this.visitorService = visitorService;
	}

	
	@GetMapping("/{sessionId}")
	public String showActorProf(@PathVariable("sessionId") int id, Model model) throws IOException {
		
		Session entity = sessionService.findById(id);
		
		if(entity == null) return "redirect:/";
		
		ThePlay play = entity.getPlay();
		
		
		
		model.addAttribute("playImageSrc", CustomFileUtils.getImage("play_" + play.getId(), play.getPlayImage()));
		model.addAttribute("ticketsList", ticketService.findAllTickets());
		model.addAttribute("session", entity);
		return "session/session-profile";
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
			                  BindingResult result) {
		
		if(result.hasErrors()) {
			return "session/add-session";
		}
		
		Session session = SessionMapper.toSession(request);
		sessionService.save(session);
		return "redirect:/session/list";
	}
	
	@GetMapping("edit/{sessionId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showSessionEditForm(@PathVariable("sessionId") int sessionId, Model model) {
		Session session = sessionService.findById(sessionId);
		EditSessionRequest request = SessionMapper.entityToEdit(session);
		
		model.addAttribute("playList", playService.findAllPlays());
		model.addAttribute("editSession", request);
		return "session/edit-session";
	}
	
	@PostMapping("edit/{sessionId}")
	public String editSession(@ModelAttribute("editSession") EditSessionRequest request,
			                  @PathVariable("sessionId") int sessionId) {
		Session session = SessionMapper.editToSession(request);
		sessionService.save(session);
		
		return "redirect:/session/list";
	}
	
	@GetMapping("/delete/{sessionId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteSession(@PathVariable("sessionId") int sessionId) {
		sessionService.deleteSessionById(sessionId);
		return "redirect:/admin";
	}
	
	
}
