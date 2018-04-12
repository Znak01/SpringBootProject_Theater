package ua.springboot.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.springboot.web.domain.ActorRequest;
import ua.springboot.web.service.ActorService;

@Component 
public class CheckActorExistsValidator implements ConstraintValidator<CheckActorExists, ActorRequest> {

	@Autowired private ActorService actorService;
	
	@Override
	public void initialize(CheckActorExists arg0) {
		
	}

	@Override
	public boolean isValid(ActorRequest request, ConstraintValidatorContext context) {
		if(request == null) return false;
		
        return actorService.findActorByFirstNameLastName(request.getFirstName(), request.getLastName()) == null ? true : false;
	}

	
	
}
