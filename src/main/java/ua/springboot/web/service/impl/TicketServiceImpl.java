package ua.springboot.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.Session;
import ua.springboot.web.entity.Ticket;
import ua.springboot.web.repository.TicketRepository;
import ua.springboot.web.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRep;
	
	@Override
	public void save(Ticket ticket) {
		ticketRep.save(ticket);
		
	}

	@Override
	public List<Ticket> findAllTickets() {
		return ticketRep.findAll();
	}

	@Override
	public Ticket findById(int id) {
		return ticketRep.findOne(id);
	}


	@Override
	public Ticket findBySessionRowSeat(Session session, String row, String seat) {
		return ticketRep.findTicketBySessionRowSeat(session, row, seat);
	}

	@Override
	public void deleteTicketById(int id) {
		ticketRep.delete(id);
	}

}
