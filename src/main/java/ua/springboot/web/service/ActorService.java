package ua.springboot.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.springboot.web.domain.ActorFilter;
import ua.springboot.web.entity.Actor;



public interface ActorService {

	void save(Actor actor);
		
	List<Actor> findAllActors();
	
	Page<Actor> findAllActorsByPage(Pageable pageable);
	
	Page<Actor> findAllActorsByFullName(Pageable pageable, ActorFilter actorFilter);
	
	Actor findById(int id);
	
	Actor findActorByFirstNameLastName(String firstName, String lastName);
	
	void deleteActorById(int id);
	
}
