package ua.springboot.web.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPlayExistsValidator.class)
public @interface CheckPlayExists {

	String message() default "Typed play already in exists";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
	
}
