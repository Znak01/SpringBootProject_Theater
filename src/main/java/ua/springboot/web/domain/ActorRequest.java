package ua.springboot.web.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Gender;


@NoArgsConstructor
@Getter @Setter
public class ActorRequest {

	@NotEmpty(message = "Cant be empty") private String firstName;
	@NotEmpty(message = "Cant be empty") private String lastName;
	@NotNull(message = "Cant be empty") private Integer age;
	@NotNull(message = "Cant be empty") private Gender gender;
	
	@NotNull(message = "Cant be empty") private MultipartFile actorImage;
	
	
}
