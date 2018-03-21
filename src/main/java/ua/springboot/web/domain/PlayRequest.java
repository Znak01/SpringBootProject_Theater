package ua.springboot.web.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Genre;

@NoArgsConstructor
@Getter @Setter
public class PlayRequest {

    private String name;
	private Genre genre;
	private BigDecimal price;
	
}
