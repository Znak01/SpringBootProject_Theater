package ua.springboot.web.domain;

import java.math.BigDecimal;

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
	@NotNull private Genre genre;
	@NotNull private BigDecimal price;
	
}
