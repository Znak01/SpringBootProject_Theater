package ua.springboot.web.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.ThePlay;
import ua.springboot.web.entity.Visitor;

@NoArgsConstructor
@Getter @Setter
public class EditSessionRequest {

	private int id;
	private String date;
	private String time;

	private ThePlay play;
	private List<Visitor> visitors;
	
}
