package ru.vasilev.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.vasilev.taskmanager.model.Task;
import ru.vasilev.taskmanager.service.TaskService;

@RestController
@RequestMapping("/v1/api/tasks")
public class TaskRestController {
	private final TaskService taskService;

	@Autowired
	public TaskRestController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks(){
		return ResponseEntity.ok(taskService.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Task> getById(@PathVariable Long id){
		return taskService.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Task> save(){
		return ResponseEntity.ok(taskService.save(new Task()));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask){
		return taskService.findById(id)
				.map(existingTask -> {
					existingTask.setTitle(updatedTask.getTitle());
					existingTask.setDescription(updatedTask.getDescription());
					existingTask.setStatus(updatedTask.getStatus());
					return ResponseEntity.ok(taskService.update(existingTask));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id){
		taskService.delete(id);
		return ResponseEntity.noContent().build();
	}
}