package ua.springboot.web.mapper;

import ua.springboot.web.domain.TicketRequest;
import ua.springboot.web.entity.Ticket;

public interface TicketMapper {

	public static Ticket toTicket(TicketRequest request) {
		Ticket ticket = new Ticket();
		ticket.setNumberOfRow(request.getNumberOfRow());
		ticket.setNumberOfSeat(request.getNumberOfSeat());
		ticket.setPrice(request.getPrice());
		ticket.setSession(request.getSession());
		ticket.setVisitor(request.getVisitor());

		return ticket;
	}
	
}
