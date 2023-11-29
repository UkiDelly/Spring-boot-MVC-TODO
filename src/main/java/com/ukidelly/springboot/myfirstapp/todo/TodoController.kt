package com.ukidelly.springboot.myfirstapp.todo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("/todo")
@SessionAttributes("username")
class TodoController(val todoService: TodoService) {
	
	
	@GetMapping
	fun todoList(model: Model): String {
		
		val todos = todoService.findTodoByUsername("admin")
		model.addAttribute("todos", todos)
		return "todos"
	}
	
	@GetMapping("/add-todo")
	fun showTodoView(model: Model): String {
		return "todo"
	}
	
	@PostMapping("/add-todo")
	
	fun saveTodo(model: Model, @RequestParam description: String): String {
		val username = model.getAttribute("username") as String
		todoService.addTodo(username, description)
		return "redirect:/todo"
	}
}