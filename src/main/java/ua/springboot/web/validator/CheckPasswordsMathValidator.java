package ua.springboot.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.springboot.web.domain.RegisterRequest;

@Component
public class CheckPasswordsMathValidator implements ConstraintValidator<CheckPasswordsMath, RegisterRequest> {

	@Override
	public void initialize(CheckPasswordsMath arg0) {
	}

	@Override
	public boolean isValid(RegisterRequest user, ConstraintValidatorContext context) {
		if(user.getPassword() == null || user.getPasswordConfirm() == null) {
			return false;
		}
		
		if(user.getPassword().equals(user.getPasswordConfirm())) {
			return true;
		}
		
		return false;
	}

}
