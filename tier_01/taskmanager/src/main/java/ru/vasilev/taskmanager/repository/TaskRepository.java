package ru.vasilev.taskmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.vasilev.taskmanager.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	Optional<Task> findByTitle(String title);
}