package ua.springboot.web.domain;





import org.hibernate.validator.constraints.NotEmpty;

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

	
	@NotEmpty private String login;
	@NotEmpty @CheckEmailExists
	private String email;
	@NotEmpty private String password;
	@NotEmpty private String passwordConfirm;
	private Role role;
	
}
