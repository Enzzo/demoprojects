package ru.vasilev.crudservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.vasilev.crudservice.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	Optional<Item> findByName(String name);
}