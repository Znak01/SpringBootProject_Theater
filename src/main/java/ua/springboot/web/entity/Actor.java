package ua.springboot.web.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Gender;

@Entity
	@Getter @Setter
	@NoArgsConstructor
	@Table(name = "actor")
	public class Actor extends BaseEntity {

		
		@Column(name = "first_name")
		private String firstName;
		
		@Column(name = "last_name")
		private String lastName;
		
		private Integer age;
		
		@Enumerated(EnumType.STRING)
		@Column(name ="gender")
		private Gender gender;
		
		@Column(name = "actor_image")
		private String actorImage;
		
		@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
				CascadeType.PERSIST, CascadeType.REFRESH})
		@JoinTable(name = "actors_plays", joinColumns = @JoinColumn(name = "actor_id"),
			    inverseJoinColumns = @JoinColumn(name = "play_id"))
		private Set<ThePlay> plays;
		
		

		
	
}
