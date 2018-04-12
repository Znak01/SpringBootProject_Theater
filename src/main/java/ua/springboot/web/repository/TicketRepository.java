package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.Session;
import ua.springboot.web.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	@Query("SELECT t FROM Ticket t WHERE t.session = :session AND t.numberOfRow = :numberOfRow AND t.numberOfSeat = :numberOfSeat")
	Ticket findTicketBySessionRowSeat(@Param("session") Session session, @Param("numberOfRow") String numberOfRow, @Param("numberOfSeat") String numberOfSeat);
}
