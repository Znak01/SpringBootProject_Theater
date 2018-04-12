package ua.springboot.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	@Override
	public Page<ThePlay> findAllPlaysByPage(Pageable pageable) {
		PageRequest request = new PageRequest(
				pageable.getPageNumber(), 
				pageable.getPageSize() - 7, 
				pageable.getSort());
		return playRepository.findAll(request);
	}

	@Override
	public ThePlay findPlayByName(String name) {
		return playRepository.findPlayByName(name);
	}

	@Override
	public void deletePlayById(int id) {
		playRepository.delete(id);
	}

}
