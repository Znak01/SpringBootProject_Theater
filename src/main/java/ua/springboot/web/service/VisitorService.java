package ua.springboot.web.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.springboot.web.domain.VisitorFilter;
import ua.springboot.web.entity.Visitor;

public interface VisitorService {

    void save(Visitor visitor, String token);
    
    void saveEditVisitor(Visitor visitor);
	
	List<Visitor> findAllVisitors();
	
	Page<Visitor> findAllVisitorsByPage(Pageable pageable);
	
	Page<Visitor> findAllVisitorsByLogin(Pageable pageable, VisitorFilter filter);
	
	Visitor findById(int id);
	
	Visitor findVisitorByEmail(String email);
	
	void deleteVisitorById(int id);
	
}
