package ua.springboot.web.domain;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Genre;
import ua.springboot.web.validator.CheckPlayExists;

@NoArgsConstructor
@Getter @Setter
public class PlayRequest {

	@NotBlank(message = "Cant be empty") @Pattern(regexp="^[a-zA-Z]{2,10}$", message="Play Name not match") @CheckPlayExists
	private String name;
	@NotEmpty(message = "Cant be empty") private Set<Genre> genres;
	@NotNull(message = "Cant be empty") @Min(100) @Max(1000) 
	private BigDecimal price;
	
}
