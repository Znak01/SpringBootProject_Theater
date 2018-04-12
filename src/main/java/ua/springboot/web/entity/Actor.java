package ua.springboot.web.entity;

import java.util.Set;

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

@Entity
	@Getter @Setter
	@NoArgsConstructor
	@Table(name = "actor", indexes = @Index(columnList = "first_name, last_name"))
	public class Actor extends BaseEntity {

		
		@Column(name = "first_name")
		private String firstName;
		
		@Column(name = "last_name")
		private String lastName;
		private String fullName;
		private String age;
		
		@Enumerated(EnumType.STRING)
		@Column(name ="gender")
		private Gender gender;
		
		@Column(name = "actor_image")
		private String actorImage;
		
		@ManyToMany(mappedBy="actors", cascade = {CascadeType.DETACH, CascadeType.MERGE, 
				CascadeType.PERSIST, CascadeType.REFRESH})
		
		private Set<ThePlay> plays;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((age == null) ? 0 : age.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((gender == null) ? 0 : gender.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Actor other = (Actor) obj;
			if (age == null) {
				if (other.age != null)
					return false;
			} else if (!age.equals(other.age))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (gender != other.gender)
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			return true;
		}
		
		

		
	
}
