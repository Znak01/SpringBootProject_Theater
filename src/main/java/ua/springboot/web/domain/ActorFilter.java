package ua.springboot.web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ActorFilter {

	private String fullName;
	
	public ActorFilter(String fullName) {
		super();
		this.fullName = fullName;
	}
	
	
	
}
