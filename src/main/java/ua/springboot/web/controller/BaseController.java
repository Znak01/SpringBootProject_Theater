package ua.springboot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.springboot.web.domain.LoginRequest;
import ua.springboot.web.domain.RegisterRequest;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.service.VisitorService;

@Controller
public class BaseController {
	
	@Autowired
 	private VisitorService visitorService;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginModel", new LoginRequest());
		return "login";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("registerModel", new RegisterRequest());
		return "register";
	}
	
	@PostMapping("/register")
	public String saveVisitor(@ModelAttribute("registerModel") @Valid RegisterRequest request,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "register";
		}
		
		visitorService.save(UserMapper.registerToUser(request));
		
		return "redirect:/login";
	}

}
