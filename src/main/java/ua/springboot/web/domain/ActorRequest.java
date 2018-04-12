package ua.springboot.web.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Gender;
import ua.springboot.web.validator.CheckActorExists;


@NoArgsConstructor
@Getter @Setter
@CheckActorExists
public class ActorRequest {

	@NotBlank(message = "Cant be empty") @Pattern(regexp="^[a-zA-Z]{2,10}$", message="First Name not match") 
	private String firstName;
	@NotBlank(message = "Cant be empty") @Pattern(regexp="^[a-zA-Z]{2,10}$", message="Last Name not match") 
	private String lastName;
	@NotNull(message = "Cant be empty") @Pattern(regexp="^[0-9]{1,3}$", message="Age not match") 
	private String age;
    private Gender gender;
//	private String fullName;
	private MultipartFile actorImage;
	
	
}
