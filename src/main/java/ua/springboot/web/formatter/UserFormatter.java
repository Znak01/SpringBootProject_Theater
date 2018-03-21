package ua.springboot.web.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import ua.springboot.web.entity.Visitor;

@Component
public class UserFormatter implements Formatter<Visitor> {
	
	@Override
	public Visitor parse(String text, Locale locale) throws ParseException {
		Visitor entity = new Visitor();
		entity.setId(Integer.valueOf(text));
		return entity;
	}

	@Override
	public String print(Visitor object, Locale locale) {
		return String.valueOf(object.getId());
	}

}
