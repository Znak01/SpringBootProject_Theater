package ua.springboot.web.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.Genre;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "the_play", indexes = @Index(columnList = "name"))
public class ThePlay extends BaseEntity {

	private String name;
	
	@ElementCollection(targetClass=Genre.class)
	@Enumerated(EnumType.STRING)
	private Set<Genre> genres;
	
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal price;
	
	@Column(name = "play_image")
	private String playImage;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinTable(name = "plays_actors", joinColumns = @JoinColumn(name = "play_id"),
    inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private Set<Actor> actors;
	
	@OneToMany(mappedBy = "play")
	private Set<Session> sessions;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ThePlay other = (ThePlay) obj;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
		
	
}
