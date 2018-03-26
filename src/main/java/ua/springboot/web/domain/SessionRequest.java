package ua.springboot.web.domain;

import java.util.Set;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.ThePlay;

@NoArgsConstructor
@Getter @Setter
public class SessionRequest {

	@NotEmpty private String date;
	@NotEmpty private String time;
	
	private Set<ThePlay> plays;
	
}
