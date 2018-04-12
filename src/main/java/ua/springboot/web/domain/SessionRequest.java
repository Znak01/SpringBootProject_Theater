package ua.springboot.web.domain;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.ThePlay;
import ua.springboot.web.validator.CheckSessionTime;

@NoArgsConstructor
@Getter @Setter
@CheckSessionTime
public class SessionRequest {

	@NotBlank(message = "Cant be empty") private String date;
	@NotBlank(message = "Cant be empty") private String time;
	
	private ThePlay play;
	
}
