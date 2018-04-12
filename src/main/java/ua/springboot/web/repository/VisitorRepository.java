package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer>, 
                                         JpaSpecificationExecutor<Visitor>{

	@Query("SELECT v FROM Visitor v WHERE v.email = :email")
	Visitor findVisitorForAuthentication(@Param("email") String email);
	
	@Query("SELECT v FROM Visitor v WHERE v.email = :email")
	Visitor findVisitorByEmail(@Param("email") String email);
	
}
