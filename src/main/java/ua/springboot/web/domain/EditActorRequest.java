package ua.springboot.web.domain;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.ThePlay;
import ua.springboot.web.entity.enumeration.Gender;

@NoArgsConstructor
@Getter @Setter
public class EditActorRequest {

	private int id;
	@NotBlank(message = "Cant be empty") @Pattern(regexp="^[a-zA-Z]{2,10}$", message="First Name not match") 
	private String firstName;
	@NotBlank(message = "Cant be empty") @Pattern(regexp="^[a-zA-Z]{2,10}$", message="Last Name not match") 
	private String lastName;
	
	private String fullName;
	@NotNull(message = "Cant be empty") @Pattern(regexp="^[0-9]{1,3}$", message="Age not match")
	private String age;
	private Gender gender;
	
	private Set<ThePlay> plays;
	
	private MultipartFile actorImage;
	
}
