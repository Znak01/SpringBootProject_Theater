package ua.springboot.web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Gender;

@NoArgsConstructor
@Getter @Setter
public class VisitorProfileRequest {

	private int id;
	private String login;
	private String email;
	private String mobile;
	private Integer age;
	private String firstName;
	private String lastName;
	private Gender gender;
	
}
