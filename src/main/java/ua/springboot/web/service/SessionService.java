package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.Session;

public interface SessionService {

    void save(Session session);
	
	List<Session> findAllSessions();
	
	Session findById(int id);
	
	Session findSessionByDate(String date, String time);
	
	void deleteSessionById(int id);
	
}
