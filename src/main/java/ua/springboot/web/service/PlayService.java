package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.ThePlay;

public interface PlayService {

	void save(ThePlay play);
	
	List<ThePlay> findAllPlays();
	
	ThePlay findById(int id);
	
	
}
