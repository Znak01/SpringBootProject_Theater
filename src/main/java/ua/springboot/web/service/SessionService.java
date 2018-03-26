package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.Session;

public interface SessionService {

    void save(Session session);
	
	List<Session> findAllSessions();
	
	Session findById(int id);
	
}
