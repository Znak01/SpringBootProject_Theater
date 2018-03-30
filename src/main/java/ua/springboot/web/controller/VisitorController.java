package ua.springboot.web.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.springboot.web.domain.EditUserRequest;
import ua.springboot.web.domain.VisitorProfileRequest;
import ua.springboot.web.entity.Session;
import ua.springboot.web.entity.Visitor;
import ua.springboot.web.entity.enumeration.Gender;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.service.SessionService;
import ua.springboot.web.service.VisitorService;
import ua.springboot.web.service.utils.CustomFileUtils;

@Controller
@RequestMapping("/visitor")
@SessionAttributes("editModel")
public class VisitorController {

	
	private VisitorService visitorService;
	private SessionService sessionService;
	
	
	@Autowired
	public VisitorController(VisitorService visitorService, SessionService sessionService) {
		super();
		this.visitorService = visitorService;
		this.sessionService = sessionService;
	}

	
	

	@GetMapping
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	public String showVisitorProf(Principal principal, Model model) throws IOException {
		
		Visitor entity = visitorService.findVisitorByEmail(principal.getName());
		
		if(entity == null) return "redirect:/";
		VisitorProfileRequest request = UserMapper.entityToProfile(entity);
		
		model.addAttribute("imageSrc", CustomFileUtils.getImage("visitor_" + entity.getId(), entity.getVisitorImage()));
		model.addAttribute("visitor", request);
		return "visitor/profile";
	}
	
	@GetMapping("/list")
	public String showVisitorList(Model model) {
		model.addAttribute("visitorList", visitorService.findAllVisitors());
		return "visitor/visitor-list";
	}
	
	@GetMapping("/edit/{visitorId}")
	public String showVisitorEdingForm(@PathVariable("visitorId") int visitorId,
			                         Model model, Principal principal) {
		Visitor visitro = visitorService.findVisitorByEmail(principal.getName());
		
		if( visitorId != visitro.getId()) {return "redirect:/";}
		EditUserRequest request = UserMapper.entityToEditUser(visitro);
		
		model.addAttribute("gender", Gender.values());
		model.addAttribute("editModel", request);
		
		return "visitor/edit-profile";
	}
	
	@PostMapping("/edit/{visitorId}")
	public String saveEditVisitor(@ModelAttribute("editModel") EditUserRequest request,
			@PathVariable("visitorId") int visitorId) throws IOException {
		
		Visitor entity = UserMapper.editRequestToEntity(request);
		visitorService.saveEditVisitor(entity);
		CustomFileUtils.createFolder("visitor_" + entity.getId());
		CustomFileUtils.createImage("visitor_" + entity.getId(), request.getFile());		
		return "redirect:/visitor";
	}
	
	@GetMapping("buy/{sessionId}")
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	public String showBuyForm(@PathVariable("sessionId") int sessionId, Principal principal, Model model) {
		Visitor visitor = visitorService.findVisitorByEmail(principal.getName());
		if(visitor == null) return "redirect:/";
		
		
		Session session = sessionService.findById(sessionId);
		EditUserRequest userRequest = UserMapper.entityToEditUser(visitor);
		userRequest.getSessions().add(session);
		
		
		
		model.addAttribute("seatsList", session.getSeatsList());
		model.addAttribute("editModel", userRequest);
		return "session/buy-form";
	}
	
	
	@PostMapping("buy/{sessionId}")
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	public String buyTicket(@ModelAttribute("editModel") EditUserRequest userRequest,
			                @PathVariable("sessionId") int sessionId) {
		
		Session session = sessionService.findById(sessionId);
		session.getSeatsList().removeAll(userRequest.getSeats());
		
		Visitor visitor = UserMapper.editRequestToEntity(userRequest);
		visitorService.saveEditVisitor(visitor);
		return "redirect:/session/list";
	}
	
}
