package ru.vasilev.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.vasilev.taskmanager.model.Task;
import ru.vasilev.taskmanager.repository.TaskRepository;

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

	public Task findById(Long id) {
		return taskRepository.findById(id).orElse(null);
	}

	public Task findByTitle(String title) {
		return taskRepository.findByTitle(title).orElse(null);
	}

	public Task save(Task task) {
		return taskRepository.save(task);
	}
	
	public void update(Long id, Task task) {
		task.setId(id);
		taskRepository.save(task);
	}

	public void delete(Long id) {
		Task taskToDelete = taskRepository.findById(id).orElse(null);
		if (taskToDelete != null) {
			taskRepository.delete(taskToDelete);
		}
	}
}