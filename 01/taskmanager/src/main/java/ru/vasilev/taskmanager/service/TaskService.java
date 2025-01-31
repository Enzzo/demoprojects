package ru.vasilev.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.vasilev.taskmanager.model.Task;
import ru.vasilev.taskmanager.repository.TaskRepository;

@Service
public class TaskService {
	private TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
}