package ua.springboot.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "session")
public class Session extends BaseEntity {
	
	private String date;
	private String time;
	List<Integer> seatsList;
	
	
	public Session(List<Integer> seatsList) {
		super();
		this.seatsList = new ArrayList<>();
		for (int i = 1; i < 31; i++) {
			seatsList.add(i);
		}
	}


	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "play_id")
	private ThePlay play;
	
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "visitors_sessions", joinColumns = @JoinColumn(name = "visitor_id"),
    inverseJoinColumns = @JoinColumn(name = "session_id"))
	private List<Visitor> visitors = new ArrayList<>();
	
	
	
}
