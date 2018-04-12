package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.ThePlay;

@Repository
public interface PlayRepository extends JpaRepository<ThePlay, Integer> {

	@Query("SELECT p FROM ThePlay p WHERE p.name = :name")
	ThePlay findPlayByName(@Param("name") String name);
	
}
