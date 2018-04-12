package ua.springboot.web.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckActorExistsValidator.class)
public @interface CheckActorExists {

	String message() default "Typed actor already in exists";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
	
}
