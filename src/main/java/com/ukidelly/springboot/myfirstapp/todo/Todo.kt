package com.ukidelly.springboot.myfirstapp.todo

import java.time.LocalDate


data class Todo(
	val id: Int,
	val username: String,
	val description: String,
	val targetDate: LocalDate,
	val isDone: Boolean
)