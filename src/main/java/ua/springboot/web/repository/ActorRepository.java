package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

	
	
}
