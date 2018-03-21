package ua.springboot.web.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Gender;


@NoArgsConstructor
@Getter @Setter
public class ActorRequest {

	private String firstName;
	private String lastName;
	private Integer age;
	private Gender gender;
	
	private MultipartFile actorImage;
	
	
}
