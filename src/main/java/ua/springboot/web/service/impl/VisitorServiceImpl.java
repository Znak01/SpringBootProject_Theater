package ua.springboot.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.springboot.web.entity.Visitor;
import ua.springboot.web.repository.VisitorRepository;
import ua.springboot.web.service.VisitorService;

@Service
@Slf4j
public class VisitorServiceImpl implements VisitorService {

	
	private VisitorRepository visitorRepository;
	private PasswordEncoder passwordEncoder;
	
	
	
	@Autowired
	public VisitorServiceImpl(VisitorRepository visitorRepository, PasswordEncoder passwordEncoder) {
		this.visitorRepository = visitorRepository;
		this.passwordEncoder = passwordEncoder;
		
	}

	@Override
	public void save(Visitor visitor) {
		String methodName = "saveUser";
		log.debug("Start " + methodName);
		
		String password = visitor.getPassword();
		visitor.setPassword(passwordEncoder.encode(password));
		visitorRepository.save(visitor);
		
		log.debug("End " + methodName);
	}

	

	@Override
	public List<Visitor> findAllVisitors() {
		return visitorRepository.findAll();
	}

	@Override
	public Visitor findById(int id) {
		return visitorRepository.findOne(id);
	}

	@Override
	public Visitor findVisitorByEmail(String email) {
		return visitorRepository.findVisitorByEmail(email);
	}

	@Override
	public void saveEditVisitor(Visitor visitor) {
		visitorRepository.save(visitor);
	}

	
					
	

}
