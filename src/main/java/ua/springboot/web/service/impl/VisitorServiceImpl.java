package ua.springboot.web.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.springboot.web.domain.VisitorFilter;
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
	public void save(Visitor visitor, String token) {
		String methodName = "saveUser";
		log.debug("Start " + methodName);
		
		String password = visitor.getPassword();
		visitor.setPassword(passwordEncoder.encode(password));
		
		visitor.setToken(token);
		visitor.setActivated(false);
		
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

	@Override
	public Page<Visitor> findAllVisitorsByPage(Pageable pageable) {
		PageRequest request = new PageRequest(
				pageable.getPageNumber(), 
				pageable.getPageSize(), 
				pageable.getSort());
		return visitorRepository.findAll(request);
	}
	
	@Override
	public Page<Visitor> findAllVisitorsByLogin(Pageable pageable, VisitorFilter filter) {
		PageRequest request = new PageRequest(
				pageable.getPageNumber(), 
				pageable.getPageSize(), 
				pageable.getSort());
		return visitorRepository.findAll(getSpecification(filter), request);
	}
	
	private Specification<Visitor> getSpecification(VisitorFilter filter){
		return new Specification<Visitor>() {
			
			@Override
			public Predicate toPredicate(Root<Visitor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(filter.getLogin().isEmpty()) return null;
				return cb.like(root.get("login"), "%" + filter.getLogin() + "%");
			}
		};
	}

	@Override
	public void deleteVisitorById(int id) {
		visitorRepository.delete(id);
	}

	

}
