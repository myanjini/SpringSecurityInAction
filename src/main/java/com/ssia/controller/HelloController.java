package com.ssia.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.concurrent.DelegatingSecurityContextCallable;
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
	
	@GetMapping("/ciao")
	public String ciao() throws Exception {
		Callable<String> task = () -> {
			SecurityContext context = SecurityContextHolder.getContext();
			return context.getAuthentication().getName();
		};
		
		ExecutorService e = Executors.newCachedThreadPool();
		try {
			var contextTask = new DelegatingSecurityContextCallable<>(task);
			return "Ciao, " + e.submit(contextTask).get() + "!";
		} finally {
			e.shutdown();
		}
	}
}
