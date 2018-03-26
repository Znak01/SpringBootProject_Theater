package ua.springboot.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.springboot.web.service.VisitorService;

@Component
public class CheckEmailExistsValidator implements ConstraintValidator<CheckEmailExists, String> {

	@Autowired private VisitorService visitorService;
	
	@Override
	public void initialize(CheckEmailExists arg0) {
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return visitorService.findVisitorByEmail(email) == null ? true : false;
	}

	
	
}
