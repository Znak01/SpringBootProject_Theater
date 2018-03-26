package ua.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.springboot.web.entity.Actor;
import ua.springboot.web.service.ActorService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {
	
	@Autowired private ActorService actorService;
	
	@GetMapping("/actors")
	public List<Actor> getActors() {
		return actorService.findAllActors();
	}

}
