package ua.springboot.web.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genre {

	DRAMA("Drama"), MUSICAL("Musical"), MELODRAMA("Melodrama"), COMEDY("Comedy"), TRAGEGY("Tragegy"), PARODY("Parody");
	
	private String genre;

}
