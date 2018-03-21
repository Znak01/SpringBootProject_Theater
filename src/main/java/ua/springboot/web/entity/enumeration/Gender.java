package ua.springboot.web.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

	MALE("Male"), FEMALE("Female");
	
	private String gender;

	
	
	
}
