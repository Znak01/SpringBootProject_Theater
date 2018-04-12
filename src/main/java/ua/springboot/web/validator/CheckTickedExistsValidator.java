package ua.springboot.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.springboot.web.domain.TicketRequest;
import ua.springboot.web.service.TicketService;

@Component
public class CheckTickedExistsValidator implements ConstraintValidator<CheckTickedExists, TicketRequest> {

	@Autowired private TicketService ticketService;
	
	@Override
	public void initialize(CheckTickedExists arg0) {
		
	}

	@Override
	public boolean isValid(TicketRequest request, ConstraintValidatorContext context) {
		if(request == null) return false;
		
        return ticketService.findBySessionRowSeat(request.getSession(), request.getNumberOfRow(), request.getNumberOfSeat()) == null ? true : false;
		
		
	}

}
