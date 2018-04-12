package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>, 
                                         JpaSpecificationExecutor<Actor> {
	
	@Query("SELECT a FROM Actor a WHERE a.firstName = :firstName AND a.lastName = :lastName")
	Actor findActorByFirstNameLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
}
