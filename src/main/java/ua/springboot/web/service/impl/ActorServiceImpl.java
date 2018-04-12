package ua.springboot.web.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.springboot.web.domain.ActorFilter;
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

	@Override
	public Page<Actor> findAllActorsByPage(Pageable pageable) {
		PageRequest request = new PageRequest(
				pageable.getPageNumber(), 
				pageable.getPageSize() - 7, 
				pageable.getSort());
		return actorRepository.findAll(request);
	}
	
	@Override
	public Page<Actor> findAllActorsByFullName(Pageable pageable, ActorFilter actorFilter) {
		PageRequest request = new PageRequest(
				pageable.getPageNumber(), 
				pageable.getPageSize() - 7, 
				pageable.getSort());
		return actorRepository.findAll(getSpecification(actorFilter), request);
	}

	
	
	private Specification<Actor> getSpecification(ActorFilter filter){
		return new Specification<Actor>() {
			
			@Override
			public Predicate toPredicate(Root<Actor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(filter.getFullName().isEmpty()) return null;
				return cb.like(root.get("fullName"), "%" + filter.getFullName() + "%");
			}
		};
	}

	@Override
	public Actor findActorByFirstNameLastName(String firstName, String lastName) {
		return actorRepository.findActorByFirstNameLastName(firstName, lastName);
	}

	@Override
	public void deleteActorById(int id) {
		actorRepository.delete(id);
	}

}
