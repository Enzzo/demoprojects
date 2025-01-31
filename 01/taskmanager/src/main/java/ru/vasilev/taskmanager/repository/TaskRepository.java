package ru.vasilev.taskmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vasilev.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>  {
	Optional<Task> findByTitle(String title);
}