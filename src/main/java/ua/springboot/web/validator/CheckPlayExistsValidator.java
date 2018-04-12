package ua.springboot.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.springboot.web.service.PlayService;

@Component
public class CheckPlayExistsValidator implements ConstraintValidator<CheckPlayExists, String> {

	@Autowired private PlayService playService;
	
	@Override
	public void initialize(CheckPlayExists arg0) {
		
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return playService.findPlayByName(name) == null ? true : false;
	}

	
	
}
