package ua.springboot.web.domain;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.ThePlay;
import ua.springboot.web.entity.Ticket;

@NoArgsConstructor
@Getter @Setter
public class EditSessionRequest {

	private int id;
	@NotBlank(message = "Cant be empty") private String date;
	@NotBlank(message = "Cant be empty") private String time;
	private Set<String> rows;
	private Collection<String> seats;

	private ThePlay play;
	private List<Ticket> tickets;
	
}
