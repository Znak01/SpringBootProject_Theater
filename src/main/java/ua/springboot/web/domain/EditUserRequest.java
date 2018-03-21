package ua.springboot.web.domain;



import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Gender;
import ua.springboot.web.entity.enumeration.Role;


@NoArgsConstructor
@Getter @Setter
public class EditUserRequest {

	private int id;
    private String login;
    private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String mobile;
	private Integer age;
	private Gender gender;
	private Role role;
	private MultipartFile file;
//	private Country country;
	
	
}
