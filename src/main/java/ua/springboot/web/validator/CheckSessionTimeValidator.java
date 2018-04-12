package ua.springboot.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.springboot.web.domain.SessionRequest;
import ua.springboot.web.service.SessionService;

@Component
public class CheckSessionTimeValidator implements ConstraintValidator<CheckSessionTime, SessionRequest> {

	@Autowired private SessionService sessionService;
	
	@Override
	public void initialize(CheckSessionTime arg0) {
		
	}

	@Override
	public boolean isValid(SessionRequest request, ConstraintValidatorContext arg1) {
		if(request == null) return false;
		
		return sessionService.findSessionByDate(request.getDate(), request.getTime()) == null ? true : false;
		
	}

}
