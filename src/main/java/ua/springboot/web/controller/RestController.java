package ua.springboot.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.springboot.web.entity.Actor;
import ua.springboot.web.entity.ThePlay;
import ua.springboot.web.service.ActorService;
import ua.springboot.web.service.PlayService;
import ua.springboot.web.service.utils.CustomFileUtils;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {
	
	private ActorService actorService;
	private PlayService playService;
	
	
	@Autowired
	public RestController(ActorService actorService, PlayService playService) {
		super();
		this.actorService = actorService;
		this.playService = playService;
	}



	@GetMapping("/actors")
	public List<Actor> getActors() throws IOException {
		 List<Actor> actors = actorService.findAllActors();
	        
	        
	        
	        for(int i = 0; i < actors.size(); i++) {
	            String imageName = actors.get(i).getActorImage();
	            
	            actors.get(i).setActorImage(CustomFileUtils.getImage("actor_" + actors.get(i).getId(), imageName)); 
	        }
	        
	        return actors;
	}
	
	@GetMapping("/plays")
	public List<ThePlay> getPlays() throws IOException {
		 List<ThePlay> plays = playService.findAllPlays();
	        
	        for(int i = 0; i < plays.size(); i++) {
	        	String imageName = plays.get(i).getPlayImage();
	        	
	            plays.get(i).setPlayImage(CustomFileUtils.getImage("play_" + plays.get(i).getId(), imageName));
	        }
	        
	        return plays;
	}

}
