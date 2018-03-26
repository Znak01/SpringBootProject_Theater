package ua.springboot.web.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "session")
	private Set<ThePlay> plays = new HashSet<>();
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "visitors_sessions", joinColumns = @JoinColumn(name = "visitor_id"),
    inverseJoinColumns = @JoinColumn(name = "session_id"))
	private List<Visitor> visitors = new ArrayList<>();
	
}
