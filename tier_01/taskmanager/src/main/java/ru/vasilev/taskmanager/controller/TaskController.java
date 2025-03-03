package ru.vasilev.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import ru.vasilev.taskmanager.model.Task;
import ru.vasilev.taskmanager.service.TaskService;

@Slf4j
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
	
	@GetMapping("/edit/{id}")
	public String getTask(@PathVariable Long id, Model model) {
		Task task = taskService.findById(id).orElse(null);
		model.addAttribute("task", task);
		return "tasks/editTask";
	}
	
	@GetMapping("/create")
	public String showCreateForm(Model model) {
		model.addAttribute("task", new Task());
		return "tasks/create";
	}
	
	@PostMapping
	public String updateTask(@ModelAttribute @Valid Task task, Errors errors) {
		if(errors.hasErrors()) {
			return "/tasks/" + task.getId();
		}
		log.info(task.toString());
		taskService.update(task);
		return "redirect:/tasks/list";
	}
	
	@PostMapping("/create")
	public String createTask(@ModelAttribute @Valid Task task, Errors errors, RedirectAttributes redirectAttributes) {
		
		if(errors.hasErrors()) {
			return "/tasks/create";
		}
		
		redirectAttributes.addFlashAttribute("message", "Задача успешно создана");
		
		taskService.save(task);
		return "redirect:/tasks/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable Long id) {
		taskService.delete(id);
		return "redirect:/tasks/list";
	}
}