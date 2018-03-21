package ua.springboot.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.Actor;
import ua.springboot.web.repository.ActorRepository;
import ua.springboot.web.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository actorRepository;
	
	@Override
	public void save(Actor actor) {
		actorRepository.save(actor);
	}

	@Override
	public List<Actor> findAllActors() {
		return actorRepository.findAll();
	}

	@Override
	public Actor findById(int id) {
		return actorRepository.findOne(id);
	}

	

}
