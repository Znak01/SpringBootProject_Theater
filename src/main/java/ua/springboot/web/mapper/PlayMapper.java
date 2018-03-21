package ua.springboot.web.mapper;

import ua.springboot.web.domain.EditPlayRequest;
import ua.springboot.web.domain.PlayRequest;
import ua.springboot.web.entity.ThePlay;

public interface PlayMapper {

	public static ThePlay toPlay(PlayRequest request) {
		ThePlay play = new ThePlay();
		play.setName(request.getName());
		play.setPrice(request.getPrice());
		play.setGenre(request.getGenre());
		return play;
	}
	
	public static EditPlayRequest entityToEditPlay(ThePlay entity) {
		EditPlayRequest request = new EditPlayRequest();
		request.setId(entity.getId());
		request.setName(entity.getName());
		request.setGenre(entity.getGenre());
		request.setPrice(entity.getPrice());
		request.setActors(entity.getActors());
		request.setSession(entity.getSession());
		return request;
	}
	
	public static ThePlay editPlayToEntity(EditPlayRequest request) {
		ThePlay play = new ThePlay();
		play.setId(request.getId());
		play.setName(request.getName());
		play.setGenre(request.getGenre());
		play.setPrice(request.getPrice());
		play.setActors(request.getActors());
		play.setSession(request.getSession());
		play.setPlayImage(request.getPlayImage().getOriginalFilename()); 
		return play;
	}
	
}
