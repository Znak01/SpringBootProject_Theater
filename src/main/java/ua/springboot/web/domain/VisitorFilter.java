package ua.springboot.web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class VisitorFilter {

	private String login;

	public VisitorFilter(String login) {
		super();
		this.login = login;
	}
	
	
	
}
