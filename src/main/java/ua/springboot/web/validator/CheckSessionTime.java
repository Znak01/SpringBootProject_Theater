package ua.springboot.web.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckSessionTimeValidator.class)
public @interface CheckSessionTime {

	String message() default "Typed time already blocked";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
	
}
