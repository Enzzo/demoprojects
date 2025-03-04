package ru.vasilev.contactmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.vasilev.contactmanager.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	Optional<Contact> findByName(String name);
	Optional<Contact> findByEmail(String email);
}