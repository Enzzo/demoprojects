package ru.vasilev.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.vasilev.taskmanager.model.Task;
import ru.vasilev.taskmanager.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	private final TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping("/list")
	public String listTasks(Model model) {
		model.addAttribute("tasks", taskService.findAll());
		return "tasks/list";
	}
	
	@GetMapping("/create")
	public String showCreateForm(Model model) {
		model.addAttribute("task", new Task());
		return "tasks/create";
	}
	
	@PostMapping("/create")
	public String createTask(@ModelAttribute Task task) {
		taskService.save(task);
		return "redirect:/tasks";
	}
}