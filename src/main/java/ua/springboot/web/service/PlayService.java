package ua.springboot.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.springboot.web.entity.ThePlay;

public interface PlayService {

	void save(ThePlay play);
	
	List<ThePlay> findAllPlays();
	
	Page<ThePlay> findAllPlaysByPage(Pageable pageable);
	
	ThePlay findById(int id);
	
	ThePlay findPlayByName(String name);
	
	void deletePlayById(int id);
	
}
