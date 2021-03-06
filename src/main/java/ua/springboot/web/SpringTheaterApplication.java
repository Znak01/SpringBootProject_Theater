package ua.springboot.web;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import ua.springboot.web.entity.Visitor;
import ua.springboot.web.entity.enumeration.Role;
import ua.springboot.web.repository.VisitorRepository;

@SpringBootApplication
public class SpringTheaterApplication 
 extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				 SpringApplication.run(SpringTheaterApplication.class, args);
		
		addAdmin(context);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootApplication.class);
	}
	
	static void addAdmin(ConfigurableApplicationContext context) {
	       String email = "admin@gmail.com";
	       String password = "123";
	       String login = "Admin";
	       
	       VisitorRepository visitorRepository = context.getBean(VisitorRepository.class);
	       Visitor entity = visitorRepository.findVisitorByEmail(email);
	       
	       if(entity == null) {
	    	   PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
	    	   entity = new Visitor();
	    	   entity.setEmail(email);
	    	   entity.setLogin(login);
	    	   entity.setPassword(encoder.encode(password));
	    	   entity.setActivated(true);
	    	   entity.setBalance(new BigDecimal(999.99));
	    	   entity.setRole(Role.ROLE_ADMIN);
	    	   
	    	   visitorRepository.save(entity);
	       }
	       
	}
	
}
