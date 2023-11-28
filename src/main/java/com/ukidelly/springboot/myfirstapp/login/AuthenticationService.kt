package com.ukidelly.springboot.myfirstapp.login

import org.springframework.stereotype.Service


@Service
class AuthenticationService {
	
	fun authenticate(username: String, password: String): Boolean {
		
		val isValidUserName = username == "admin"
		val isValidPassword = password == "admin"
		return isValidUserName && isValidPassword
	}
}