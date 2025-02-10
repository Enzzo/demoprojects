package ru.vasilev.taskmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.vasilev.taskmanager.model.Task;
import ru.vasilev.taskmanager.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	private TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}
	
	@PostMapping
	public Task createTask(@RequestBody Task task) {
		Task t = taskService.saveTask(task);
		return t;
	}
}