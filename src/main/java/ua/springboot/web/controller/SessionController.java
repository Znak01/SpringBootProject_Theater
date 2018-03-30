package ua.springboot.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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
import ua.springboot.web.domain.EditUserRequest;
import ua.springboot.web.domain.SessionRequest;
import ua.springboot.web.entity.Session;
import ua.springboot.web.entity.Visitor;
import ua.springboot.web.mapper.SessionMapper;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.service.PlayService;
import ua.springboot.web.service.SessionService;
import ua.springboot.web.service.VisitorService;

@Controller
@RequestMapping("/session")
@SessionAttributes({"editSession", "editVisitor"})
public class SessionController {

	private SessionService sessionService;
	private PlayService playService;
	private VisitorService visitorService;
	
	
	@Autowired
	public SessionController(SessionService sessionService, PlayService playService, VisitorService visitorService) {
		super();
		this.sessionService = sessionService;
		this.playService = playService;
		this.visitorService = visitorService;
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
	
	@GetMapping("buy/{sessionId}")
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	public String showBuyForm(@PathVariable("sessionId") int sessionId, Principal principal, Model model) {
		Visitor visitor = visitorService.findVisitorByEmail(principal.getName());
		if(visitor == null) return "redirect:/";
		
		
		Session session = sessionService.findById(sessionId);
		session.getVisitors().add(visitor);
		EditSessionRequest request = SessionMapper.entityToEdit(session);
		EditUserRequest userRequest = UserMapper.entityToEditUser(visitor);
		List<Integer> seatsList = new ArrayList<>();
		for (int i = 1; i < 31; i++) {
			seatsList.add(i);
		}
		
		model.addAttribute("seatsList", seatsList);
		model.addAttribute("editSession", request);
		model.addAttribute("editVisitor", userRequest);
		return "session/buy-form";
	}
	
	
	@PostMapping("buy/{sessionId}")
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	public String buyTicket(@ModelAttribute("editSession") EditSessionRequest request, 
			                @ModelAttribute("editVisitor") EditUserRequest userRequest,
			                @PathVariable("sessionId") int sessionId) {
		
		
		
		Visitor visitor = UserMapper.editRequestToEntity(userRequest);
		Session session = SessionMapper.editToSession(request);
		sessionService.save(session);
		visitorService.saveEditVisitor(visitor);
		return "redirect:/session/list";
	}
	
}
