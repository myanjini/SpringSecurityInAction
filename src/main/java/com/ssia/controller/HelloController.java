package com.ssia.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/hello") 
	public String hello(Authentication auth) {
		return "Hello, " + auth.getName() + "!";
	}
	
	@GetMapping("/bye")
	@Async
	public void goodbye() {
		SecurityContext context = SecurityContextHolder.getContext();
		String username = context.getAuthentication().getName();
		
		// do something with the username
	}
}
