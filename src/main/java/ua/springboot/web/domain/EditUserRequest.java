package ua.springboot.web.domain;



import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.Session;
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
	private Gender gender;
	
	private String mobile;
	private Integer age;
	private BigDecimal balance;
	private Set<Integer> seats; 
	private List<Session> sessions;
	
	private Role role;
	private MultipartFile file;
//	private Country country;
	
	
}
