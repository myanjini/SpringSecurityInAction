package com.ssia.controller;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	UserDetailsService uds;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello!";
	}
}
