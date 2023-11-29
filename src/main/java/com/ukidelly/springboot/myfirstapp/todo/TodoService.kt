package com.ukidelly.springboot.myfirstapp.todo

import org.springframework.stereotype.Service
import java.time.LocalDate


@Service
class TodoService {
	
	private val todos: MutableList<Todo> = mutableListOf(
		Todo(
			1,
			"admin",
			"Learn AWS",
			LocalDate.now().plusYears(1),
			false
		),
		Todo(
			2,
			"admin",
			"Learn Ktor",
			LocalDate.now().plusYears(1),
			false
		),
		Todo(
			3,
			"admin",
			"Learn Flutter",
			LocalDate.now().plusYears(1),
			false
		)
	)
	
	
	fun findTodoByUsername(username: String): List<Todo> {
		return todos.filter { it.username == username }
	}
	
	fun addTodo(username: String, desc: String) {
		val todo = Todo(todos.size + 1, username, desc, LocalDate.now().plusYears(1), false)
		todos.add(todo)
	}
	
	
}