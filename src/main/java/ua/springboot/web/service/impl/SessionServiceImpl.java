package ua.springboot.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.Session;
import ua.springboot.web.repository.SessionRepository;
import ua.springboot.web.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired private SessionRepository sessionRepository;
	
	@Override
	public void save(Session session) {
		sessionRepository.save(session);
	}

	@Override
	public List<Session> findAllSessions() {
		return sessionRepository.findAll();
	}

	@Override
	public Session findById(int id) {
		return sessionRepository.findOne(id);
	}

}
