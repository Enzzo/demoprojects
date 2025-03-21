package ru.vasilev.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ru.vasilev.taskmanager.model.Task;
import ru.vasilev.taskmanager.repository.TaskRepository;

@Slf4j
@Service
public class TaskService {
	private final TaskRepository taskRepository;

	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}

	public Optional<Task> findByTitle(String title) {
		return taskRepository.findByTitle(title);
	}

	public Task save(Task task) {
		return taskRepository.save(task);
	}
	
	public Task update(Task task) {
//		log.info(task.toString());
		Task taskToUpdate = taskRepository.findById(task.getId()).orElse(null);
		taskToUpdate.setTitle(task.getTitle());
		taskToUpdate.setDescription(task.getDescription());
		taskToUpdate.setStatus(task.getStatus());
		return taskRepository.save(taskToUpdate);
	}

	public void delete(Long id) {
		taskRepository.deleteById(id);	}
}