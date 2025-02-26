package ru.vasilev.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.vasilev.taskmanager.model.Task;
import ru.vasilev.taskmanager.service.TaskService;

@RestController
@RequestMapping("/v1/api/")
public class TaskRestController {
	private final TaskService taskService;

	@Autowired
	public TaskRestController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getAllTasks(){
		return ResponseEntity.ok(taskService.findAll());
	}
	
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getById(@RequestParam Long id){
		return ResponseEntity.ok(taskService.findById(id));
	}
	
	@PostMapping("/tasks")
	public ResponseEntity<Task> save(){
		return ResponseEntity.ok(taskService.save(new Task()));
	}
}