package ua.springboot.web.domain;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.Session;
import ua.springboot.web.entity.Visitor;

@NoArgsConstructor
@Getter @Setter
public class TicketRequest {

	@NotBlank(message = "Cant be empty") private String numberOfRow;
	@NotBlank(message = "Cant be empty") private String numberOfSeat;
	private BigDecimal price;
	
	private Visitor visitor;
	private Session session;
	
}
