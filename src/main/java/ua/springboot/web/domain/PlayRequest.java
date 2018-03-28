package ua.springboot.web.domain;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Genre;

@NoArgsConstructor
@Getter @Setter
public class PlayRequest {

	@NotEmpty private String name;
	private Set<Genre> genres;
	@NotNull private BigDecimal price;
	
}
