package ua.springboot.web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.ThePlay;

@NoArgsConstructor
@Getter @Setter
public class SessionRequest {

	
	private String date;
	private String time;
	
	private ThePlay play;
	
}
