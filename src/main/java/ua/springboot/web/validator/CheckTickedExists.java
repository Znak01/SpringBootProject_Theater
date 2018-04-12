package ua.springboot.web.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckTickedExistsValidator.class)
public @interface CheckTickedExists {

	String message() default "Typed ticked already booked";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
	
}
