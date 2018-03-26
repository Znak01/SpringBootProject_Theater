package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

}
