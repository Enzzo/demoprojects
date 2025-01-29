package ru.vasilev.usermanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.vasilev.usermanagement.model.Person;

@Repository
public interface UserRepository extends JpaRepository<Person, Integer>{
	Optional<Person> findByUsername(String username);
}