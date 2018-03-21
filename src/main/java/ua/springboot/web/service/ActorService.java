package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.Actor;



public interface ActorService {

	void save(Actor actor);
		
	List<Actor> findAllActors();
	
	Actor findById(int id);
	
}
