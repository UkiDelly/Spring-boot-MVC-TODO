package com.ukidelly.springboot.myfirstapp.todo

import org.springframework.stereotype.Service
import java.time.LocalDate


@Service
class TodoService {
	
	private val todos: List<Todo> = mutableListOf(
		Todo(
			1,
			"admin",
			"Learn AWS",
			LocalDate.now().plusYears(1),
			false
		)
	)
	
	
	fun findTodoByUsername(username: String): List<Todo> {
		return todos.filter { it.username == username }
	}
	
	
}