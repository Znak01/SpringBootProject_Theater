package ua.springboot.web.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Gender;
import ua.springboot.web.entity.enumeration.Role;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "visitor", indexes = @Index(columnList = "email"))
public class Visitor extends BaseEntity{

	private String login;
	private String password;
	private String email;
	
	@Column(columnDefinition = "DECIMAL(7,2)")
	private BigDecimal balance;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String mobile;
	private String age;
	
	@Column
	@ElementCollection(targetClass=Integer.class)
	private Set<Integer> seats; 
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Enumerated(EnumType.ORDINAL)
	private Role role;
	
	private String token;
	@Column(name = "is_activated")
	private boolean isActivated = false;
	@Column(name = "is_blocked")
	private boolean isBlocked = false;
	
//	private Country country;
	
	@Column(name = "visitor_image")
	private String visitorImage;
	
	@OneToMany(mappedBy = "visitor")
	private List<Ticket> tickets;
	
//	@ManyToMany(mappedBy = "visitors", cascade = {CascadeType.DETACH, CascadeType.MERGE, 
//			CascadeType.PERSIST, CascadeType.REFRESH})
//	private List<Session> sessions = new ArrayList<>();
	
	
}
