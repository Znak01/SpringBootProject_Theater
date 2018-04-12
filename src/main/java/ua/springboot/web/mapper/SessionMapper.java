package ua.springboot.web.mapper;

import java.util.ArrayList;
import java.util.Collection;

import ua.springboot.web.domain.EditSessionRequest;
import ua.springboot.web.domain.SessionRequest;
import ua.springboot.web.entity.Session;

public interface SessionMapper {

	public static Session toSession(SessionRequest request) {
		Session session = new Session();
		session.setDate(request.getDate());
		session.setTime(request.getTime());
		session.setPlay(request.getPlay());
		return session;
	}
	
	public static EditSessionRequest entityToEdit(Session session) {
		EditSessionRequest request = new EditSessionRequest();
		request.setId(session.getId());
		request.setDate(session.getDate());
		request.setTime(session.getTime());
		request.setPlay(session.getPlay());
		request.setTickets(session.getTickets());
		request.setRows(session.getRowSeatsList().keySet());
		Collection<String> seats = new ArrayList<>();
		String str = session.getRowSeatsList().get("1");
	    String sep = ","; 
	    String[] subStr = str.split(sep);
		for (String string : subStr) {
			seats.add(string);
		}
		request.setSeats(seats);
		return request;
	}
	
	public static Session editToSession(EditSessionRequest request) {
		Session session = new Session();
		session.setId(request.getId());
		session.setDate(request.getDate());
		session.setTime(request.getTime());
		session.setPlay(request.getPlay());
		session.setTickets(request.getTickets());
		return session;
	}
	
}
