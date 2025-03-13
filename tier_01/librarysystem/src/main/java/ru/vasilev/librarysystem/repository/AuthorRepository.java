package ru.vasilev.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.vasilev.librarysystem.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}