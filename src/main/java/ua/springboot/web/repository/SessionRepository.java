package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

	@Query("SELECT s FROM Session s WHERE s.date = :date AND s.time = :time")
	Session findSessionByDate(@Param("date") String date, @Param("time") String time);
	
}
