package ua.springboot.web.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "hall")
public class Session extends BaseEntity {

	private String number;
	
	@OneToMany(mappedBy = "session")
	private List<ThePlay> plays;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "visitors_halls", joinColumns = @JoinColumn(name = "visitor_id"),
    inverseJoinColumns = @JoinColumn(name = "hall_id"))
	private List<Visitor> visitors = new ArrayList<>();
	
}
