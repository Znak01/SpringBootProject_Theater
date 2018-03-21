package ua.springboot.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.ThePlay;
import ua.springboot.web.repository.PlayRepository;
import ua.springboot.web.service.PlayService;

@Service
public class PlayServiceImpl implements PlayService {

	@Autowired
	private PlayRepository playRepository;
	
	@Override
	public void save(ThePlay play) {
		playRepository.save(play);
	}

	@Override
	public List<ThePlay> findAllPlays() {
		return playRepository.findAll();
	}

	@Override
	public ThePlay findById(int id) {
		return playRepository.findOne(id);
	}

}
