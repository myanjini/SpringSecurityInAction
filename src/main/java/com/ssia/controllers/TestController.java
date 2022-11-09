package com.ssia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@PostMapping("/a")
	public String postEndpointA() {
		return "Works!";
	}

	@GetMapping("/a")
	public String getEndpointA() {
		return "Works!";
	}

	@GetMapping("/a/b")
	public String getEnpointB() {
		return "Works!";
	}

	@GetMapping("/a/b/c")
	public String getEnpointC() {
		return "Works!";
	}
	
    @GetMapping("/email/{email}")
    public String video(@PathVariable String email) {
        return "Allowed for email " + email;
    }
}