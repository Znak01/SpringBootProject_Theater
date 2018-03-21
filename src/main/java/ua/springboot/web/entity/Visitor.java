package ua.springboot.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
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
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String mobile;
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Enumerated(EnumType.ORDINAL)
	private Role role;
	
//	private Country country;
	
	@Column(name = "visitor_image")
	private String visitorImage;
	
	@ManyToMany(mappedBy = "visitors", cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Session> halls = new ArrayList<>();
	
}
