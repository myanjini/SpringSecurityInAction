package com.ssia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public String getHello() {
		return "Get Hello!";
	}
	@PostMapping("/hello")
	public String postHello() {
		return "Post Hello!";
	}
}
