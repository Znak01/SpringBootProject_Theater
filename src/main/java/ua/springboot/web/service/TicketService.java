package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.Session;
import ua.springboot.web.entity.Ticket;

public interface TicketService {

	void save(Ticket ticket);
	
    List<Ticket> findAllTickets();
	
    Ticket findById(int id);
    
    Ticket findBySessionRowSeat(Session session, String row, String seat);
    
    void deleteTicketById(int id);
	
}
