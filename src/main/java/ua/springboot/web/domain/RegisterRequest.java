package ua.springboot.web.domain;





import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Role;
import ua.springboot.web.validator.CheckEmailExists;
import ua.springboot.web.validator.CheckPasswordsMath;

@NoArgsConstructor
@Getter @Setter
@CheckPasswordsMath
public class RegisterRequest {

	
	@NotBlank(message = "Cant be empty") @Pattern(regexp="^[a-zA-Z0-9_]{2,10}$", message="Login not match")
	private String login;
	@NotBlank(message = "Cant be empty") @CheckEmailExists
	private String email;
	@NotBlank(message = "Cant be empty") @Pattern(regexp="^\\w{4,10}$", message="Password too small")
	private String password;
	@NotBlank(message = "Cant be empty") private String passwordConfirm;
	private Role role;
	
}
