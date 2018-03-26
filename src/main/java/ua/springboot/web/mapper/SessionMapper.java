package ua.springboot.web.mapper;

import ua.springboot.web.domain.SessionRequest;
import ua.springboot.web.entity.Session;

public interface SessionMapper {

	public static Session toSession(SessionRequest request) {
		Session session = new Session();
		session.setDate(request.getDate());
		session.setTime(request.getTime());
		session.setPlays(request.getPlays());
		return session;
	}
	
}
