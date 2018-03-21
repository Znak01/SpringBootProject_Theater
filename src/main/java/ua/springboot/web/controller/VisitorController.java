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
import ua.springboot.web.entity.Visitor;
import ua.springboot.web.entity.enumeration.Gender;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.service.VisitorService;
import ua.springboot.web.service.utils.CustomFileUtils;

@Controller
@RequestMapping("/visitor")
@SessionAttributes("editModel")
public class VisitorController {

	
	private VisitorService visitorService;
	
	
	
	@Autowired
	public VisitorController(VisitorService visitorService) {
		this.visitorService = visitorService;
		
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
		
//		visitorService.uploadImage(file, visitor);
		if(request.getFile().isEmpty()) {
			return "redirect:/visitor/edit/" + visitorId;
		}
		Visitor entity = UserMapper.editRequestToEntity(request);
		visitorService.saveEditVisitor(entity);
		CustomFileUtils.createFolder("visitor_" + entity.getId());
		CustomFileUtils.createImage("visitor_" + entity.getId(), request.getFile());		
		return "redirect:/visitor";
	}
	
}
