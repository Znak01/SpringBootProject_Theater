package ua.springboot.web.domain;

import java.util.ArrayList;
import java.util.List;

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
	private String firstName;
	private String lastName;
	private Integer age;
	private Gender gender;
	
	private List<ThePlay> plays = new ArrayList<>();
	
	private MultipartFile actorImage;
	
}
