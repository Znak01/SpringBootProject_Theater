package ua.springboot.web.domain;





import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Role;

@NoArgsConstructor
@Getter @Setter
public class RegisterRequest {

	
	@NotEmpty private String login;
	@NotEmpty private String email;
	@NotEmpty private String password;
	@NotEmpty private String passwordConfirm;
	private Role role;
	
}
