package ua.springboot.web.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Gender;
import ua.springboot.web.entity.enumeration.Role;

@NoArgsConstructor
@Getter @Setter
public class VisitorProfileRequest {

	private int id;
	private String login;
	private String email;
	
	private String mobile;
	private String age;
	private BigDecimal balance;
	
	private String firstName;
	private String lastName;
	private Gender gender;
	
	private boolean isBlocked;
	private Role role;
	
}
