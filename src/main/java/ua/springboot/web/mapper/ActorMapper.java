package ua.springboot.web.mapper;

import ua.springboot.web.domain.ActorRequest;
import ua.springboot.web.domain.EditActorRequest;
import ua.springboot.web.entity.Actor;


public interface ActorMapper {

	public static Actor toActor(ActorRequest request) {
		Actor actor = new Actor();
		actor.setFirstName(request.getFirstName());
		actor.setLastName(request.getLastName());
		actor.setAge(request.getAge());
		actor.setGender(request.getGender());
		actor.setFullName(request.getFirstName() + " " + request.getLastName());
		actor.setActorImage(request.getActorImage().getOriginalFilename());
		return actor;
	}
	
	public static EditActorRequest entityToEditActor(Actor entity) {
		EditActorRequest request = new EditActorRequest();
		request.setId(entity.getId());
		request.setFirstName(entity.getFirstName());
		request.setLastName(entity.getLastName());
		request.setFullName(entity.getFirstName() + " " + entity.getLastName());
		request.setAge(entity.getAge());
		request.setGender(entity.getGender());
		request.setPlays(entity.getPlays());
		return request;
	}
	
	public static Actor editRequestToActor(EditActorRequest request) {
		Actor entity = new Actor();
		entity.setId(request.getId());
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setFullName(request.getFirstName() + " " + request.getLastName());
		entity.setAge(request.getAge());
		entity.setGender(request.getGender());
		entity.setPlays(request.getPlays());
		entity.setActorImage(request.getActorImage().getOriginalFilename());
		return entity;
	}
	
}
