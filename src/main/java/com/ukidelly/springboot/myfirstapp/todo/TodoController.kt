package com.ukidelly.springboot.myfirstapp.todo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.SessionAttributes


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
}