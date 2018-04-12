package ua.springboot.web.entity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "session")
public class Session extends BaseEntity {
	
	private String date;
	private String time;
	
	@ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn(name="row")
    @CollectionTable(name="row_seats", joinColumns=@JoinColumn(name="row_seat_id"))
	@Column(name="seats")
	private Map<String, String> rowSeatsList;
	
	public Session() {
		this.rowSeatsList = new LinkedHashMap<>();
		for (int i = 1; i < 6; i++) {
			
			List<String> seatsList = new ArrayList<>();
			StringBuilder sbS = new StringBuilder();
			StringBuilder sbSep = new StringBuilder(",");
			for (int j = 1; j < 11; j++) {
				seatsList.add(Integer.toString(j));
				StringBuilder sb1 = new StringBuilder(Integer.toString(j));
				sbS.append(sb1).append(sbSep);
				
			}
			String seats = sbS.deleteCharAt(sbS.length()-1).toString();
			
			rowSeatsList.put(Integer.toString(i), seats);
		}
	}

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "play_id")
	private ThePlay play;
	
	@OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
	private List<Ticket> tickets;
	
//	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
//			CascadeType.PERSIST, CascadeType.REFRESH})
//	@JoinTable(name = "visitors_sessions", joinColumns = @JoinColumn(name = "visitor_id"),
//    inverseJoinColumns = @JoinColumn(name = "session_id"))
//	private List<Visitor> visitors = new ArrayList<>();
	
	
}
