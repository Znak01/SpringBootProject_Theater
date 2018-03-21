package ua.springboot.web.service;


import java.util.List;



import ua.springboot.web.entity.Visitor;

public interface VisitorService {

    void save(Visitor visitor);
    
    void saveEditVisitor(Visitor visitor);
	
	List<Visitor> findAllVisitors();
	
	Visitor findById(int id);
	
	Visitor findVisitorByEmail(String email);
	
	
	
}
