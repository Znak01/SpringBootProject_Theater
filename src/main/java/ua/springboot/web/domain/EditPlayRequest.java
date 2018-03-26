package ua.springboot.web.domain;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.Actor;
import ua.springboot.web.entity.Session;
import ua.springboot.web.entity.enumeration.Genre;

@NoArgsConstructor
@Getter @Setter
public class EditPlayRequest {

	private int id;
	private String name;
	private Genre genre;
	private BigDecimal price;
	private Set<Actor> actors;
	private Session session;
	
	private MultipartFile playImage;
	
}
