package ua.springboot.web.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.springboot.web.domain.LoginRequest;
import ua.springboot.web.domain.RegisterRequest;
import ua.springboot.web.entity.Visitor;
import ua.springboot.web.mail.Mail;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.service.VisitorService;
import ua.springboot.web.service.impl.EmaiServiceImpl;
import ua.springboot.web.service.impl.RandomToken;

@Controller
public class BaseController {
	
	
 	private VisitorService visitorService;
	private EmaiServiceImpl emailService;
	
	
	@Autowired
	public BaseController(VisitorService visitorService, EmaiServiceImpl emailService) {
		super();
		this.visitorService = visitorService;
		this.emailService = emailService;
	}

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
		
		Visitor visitor = UserMapper.registerToUser(request);
		String token = RandomToken.generateRandomString();
		
		visitorService.save(visitor, token);
		
		Mail mail = new Mail();
		mail.setTo(request.getEmail());
		mail.setSubject("You are successfully registered");
		mail.setContent("You are successfully registered "
	                     + "Email: " + visitor.getEmail() + ", "
		                 + "Please verify your email address by follow link: "
				         + "http://localhost:8090/verify?token=" + token
				         + "&userid=" + visitor.getId());
		
		emailService.sendMessage(mail);
		
		return "unActivated";
	}
	
	@GetMapping("/verify")
	public String verifyUser(@RequestParam("token") String token,
			                 @RequestParam("userid") String userIdStr) {
		int userId = Integer.valueOf(userIdStr);
		Visitor visitor = visitorService.findById(userId);
		
		if(visitor.getToken().equals(token)) {
			visitor.setToken("");
			visitor.setActivated(true);
			visitorService.saveEditVisitor(visitor);
		}
		
		
		return "activated";
	}

	@GetMapping("/paymant")
	public String boughtTicket(Principal principal, Model model ) {
		model.addAttribute("visitor", visitorService.findVisitorByEmail(principal.getName()));

		return "visitor/successfully-paymant";
	}
}
