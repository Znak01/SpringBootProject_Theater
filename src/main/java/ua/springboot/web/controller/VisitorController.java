package ua.springboot.web.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.springboot.web.domain.EditSessionRequest;
import ua.springboot.web.domain.EditUserRequest;
import ua.springboot.web.domain.TicketRequest;
import ua.springboot.web.domain.VisitorFilter;
import ua.springboot.web.domain.VisitorProfileRequest;
import ua.springboot.web.entity.Session;
import ua.springboot.web.entity.Ticket;
import ua.springboot.web.entity.Visitor;
import ua.springboot.web.entity.enumeration.Gender;
import ua.springboot.web.entity.enumeration.Role;
import ua.springboot.web.mail.Mail;
import ua.springboot.web.mapper.SessionMapper;
import ua.springboot.web.mapper.TicketMapper;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.service.SessionService;
import ua.springboot.web.service.TicketService;
import ua.springboot.web.service.VisitorService;
import ua.springboot.web.service.impl.EmaiServiceImpl;
import ua.springboot.web.service.utils.CustomFileUtils;

@Controller
@RequestMapping("/visitor")
@SessionAttributes("editModel")
public class VisitorController {

	
	private VisitorService visitorService;
	private SessionService sessionService;
	private TicketService ticketService;
	private EmaiServiceImpl emailService;
	
	
	@Autowired
	public VisitorController(VisitorService visitorService, SessionService sessionService, TicketService ticketService, EmaiServiceImpl emailService) {
		super();
		this.visitorService = visitorService;
		this.sessionService = sessionService;
		this.ticketService = ticketService;
		this.emailService = emailService;
	}

	
	

	@GetMapping
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	public String showVisitorProf(Principal principal, Model model) throws IOException {
		
		Visitor entity = visitorService.findVisitorByEmail(principal.getName());
		if(entity == null) return "redirect:/";
		if(!entity.isActivated()) return "unActivated";
		if(entity.isBlocked()) return "other/block";
		
		VisitorProfileRequest request = UserMapper.entityToProfile(entity);
		
		model.addAttribute("imageSrc", CustomFileUtils.getImage("visitor_" + entity.getId(), entity.getVisitorImage()));
		model.addAttribute("ticketList", entity.getTickets());
		model.addAttribute("visitor", request);
		return "visitor/profile";
	}
	
	@GetMapping("/{visitorId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showVisitorProf(@PathVariable("visitorId") int id, Model model) throws IOException {
		
		Visitor entity = visitorService.findById(id);
		if(entity == null) return "redirect:/";
		
		VisitorProfileRequest request = UserMapper.entityToProfile(entity);
		
		model.addAttribute("imageSrc", CustomFileUtils.getImage("visitor_" + entity.getId(), entity.getVisitorImage()));
		model.addAttribute("visitor", request);
		return "visitor/profile";
	}
	
	@GetMapping("/list")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showVisitorList(Model model, @PageableDefault Pageable pageable) {
        Page<Visitor> page = visitorService.findAllVisitorsByPage(pageable);
		
        int currentPage = page.getNumber();
        int begin = Math.max(1, currentPage - 2);
        int end = Math.min(begin + 2, page.getNumber());
        

		model.addAttribute("visitorList", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);
		model.addAttribute("perPage", page.getSize());
		model.addAttribute("visitorListByPageSize", page.getContent());
		
		return "visitor/visitor-list";
	}
	
	@GetMapping("/list/filter")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showVisitorListFilter(Model model, @PageableDefault Pageable pageable, 
			                                 @RequestParam("search") String search) throws IOException {
		VisitorFilter filter = null;
		if(search != null) {
			filter = new VisitorFilter(search);
		}
		Page<Visitor> page = visitorService.findAllVisitorsByLogin(pageable, filter);
		
        int currentPage = page.getNumber();
        int begin = Math.max(1, currentPage - 2);
        int end = Math.min(begin + 2, page.getNumber());
        
        
		model.addAttribute("visitorList", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);
		model.addAttribute("perPage", page.getSize());
		model.addAttribute("visitorListByPageSize", page.getContent());
		
		
		return "visitor/visitor-list";
	}
	
	@GetMapping("/edit/{visitorId}")
	public String showVisitorEdingForm(@PathVariable("visitorId") int visitorId,
			                         Model model, Principal principal) {
		Visitor visitro = visitorService.findById(visitorId);
		
		if( visitorId != visitro.getId()) {return "redirect:/";}
		EditUserRequest request = UserMapper.entityToEditUser(visitro);
		
		model.addAttribute("gender", Gender.values());
		model.addAttribute("editModel", request);
		
		return "visitor/edit-profile";
	}
	
	@PostMapping("/edit/{visitorId}")
	public String saveEditVisitor(@ModelAttribute("editModel") EditUserRequest request,
			@PathVariable("visitorId") int visitorId) throws IOException {
		
		if(request.getFile().isEmpty()) {
			return "redirect:/visitor/edit/" + visitorId;
		}
		
		Visitor entity = UserMapper.editRequestToEntity(request);
		visitorService.saveEditVisitor(entity);
		CustomFileUtils.createFolder("visitor_" + entity.getId());
		CustomFileUtils.createImage("visitor_" + entity.getId(), request.getFile());		
		return "redirect:/visitor/" + visitorId;
	}
	
	@GetMapping("/recharge/{visitorId}")
	public String showVisitorBalanceForm(@PathVariable("visitorId") int visitorId,
			                         Model model, Principal principal) {
		Visitor visitro = visitorService.findVisitorByEmail(principal.getName());
		
		if( visitorId != visitro.getId()) {return "redirect:/";}
			
		model.addAttribute("editModel", visitro);
		
		return "visitor/balance-form";
	}
	
	@PostMapping("/recharge/{visitorId}")
	public String saveEditVisitorBalance(@ModelAttribute("editModel") Visitor entity,
			@PathVariable("visitorId") int visitorId) {
		
		visitorService.saveEditVisitor(entity);
		return "redirect:/visitor";
	}
	
	
	@GetMapping("buy/{sessionId}")
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	public String showBuyForm(@PathVariable("sessionId") int sessionId, Principal principal, Model model) {
		Visitor visitor = visitorService.findVisitorByEmail(principal.getName());
		if(visitor == null) return "redirect:/";
		Session session = sessionService.findById(sessionId);
		EditSessionRequest request = SessionMapper.entityToEdit(session);
		List<Ticket> tickets = session.getTickets();
//		EditUserRequest userRequest = UserMapper.entityToEditUser(visitor);
		TicketRequest ticket = new TicketRequest();
		ticket.setVisitor(visitor);
		ticket.setSession(session);
		ticket.setPrice(session.getPlay().getPrice());
		

		
		model.addAttribute("rowList", request.getRows());
		model.addAttribute("seatsList", request.getSeats());
		model.addAttribute("ticketsList", tickets);
		model.addAttribute("ticketModel", ticket);
		return "session/buy-form";
	}
	
	
	@PostMapping("buy/{sessionId}")
	public String buyTicket(@ModelAttribute("ticketModel") TicketRequest ticketRequest, Principal principal,
			                @PathVariable("sessionId") int sessionId) {
		
		Visitor visitor = visitorService.findVisitorByEmail(principal.getName());
		if(visitor == null) return "redirect:/";
		Session session = sessionService.findById(sessionId);
		
		if(visitor.getBalance().doubleValue() < session.getPlay().getPrice().doubleValue()) {
			return "/other/not-enought";
		}
		BigDecimal balance = new BigDecimal(visitor.getBalance().doubleValue() - session.getPlay().getPrice().doubleValue());
		visitor.setBalance(balance);
		
		for (Ticket ticket : session.getTickets()) {
			if(ticket.getNumberOfRow().equals(ticketRequest.getNumberOfRow()) && ticket.getNumberOfSeat().equals(ticketRequest.getNumberOfSeat())) {
				return "/other/booked";
			}
		}
		
		
		ticketRequest.setVisitor(visitor);
		ticketRequest.setSession(session);
		ticketRequest.setPrice(session.getPlay().getPrice());
		Ticket ticket = TicketMapper.toTicket(ticketRequest);
		
		ticketService.save(ticket);
		
		Mail mail = new Mail();
		mail.setTo(visitor.getEmail());
		mail.setSubject("Ticket");
		mail.setContent("You are successfully bought the ticket "
	                     + "on Play: " + session.getPlay().getName() + ", "
		                 + "Row: " + ticketRequest.getNumberOfRow() + ", "
				         + "Seat: " + ticketRequest.getNumberOfSeat() 
				         );
		
		emailService.sendMessage(mail);
		
		return "redirect:/paymant";
	}
	
	@GetMapping("/delete/ticket/{ticketId}")
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	public String deleteTicket(@PathVariable("ticketId") int ticketId) {
		ticketService.deleteTicketById(ticketId);
		return "redirect:/visitor";
	}
	
	@GetMapping("/delete/{visitorId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteVisitor(@PathVariable("visitorId") int visitorId) {
		visitorService.deleteVisitorById(visitorId);
		return "redirect:/admin";
	}
	
	@GetMapping("/block/{visitorId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String blockVisitor(@PathVariable("visitorId") int visitorId) {
		Visitor visitor = visitorService.findById(visitorId);
		if(visitor.getRole().equals(Role.ROLE_ADMIN)) return "redirect:/visitor";
		visitor.setBlocked(true);
		visitor.setRole(Role.ROLE_BLOCKED);
		
		visitorService.saveEditVisitor(visitor);
		return "home";
	}
	
	@GetMapping("/unblock/{visitorId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String unblockVisitor(@PathVariable("visitorId") int visitorId) {
		Visitor visitor = visitorService.findById(visitorId);
		if(visitor.getRole().equals(Role.ROLE_ADMIN)) return "redirect:/visitor";
		visitor.setBlocked(false);
		visitor.setRole(Role.ROLE_USER);
		
		visitorService.saveEditVisitor(visitor);
		return "home";
	}
	
	
}
