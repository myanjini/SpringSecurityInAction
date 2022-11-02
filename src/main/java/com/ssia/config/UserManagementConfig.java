package com.ssia.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ssia.model.User;
import com.ssia.services.InMemoryUserDetailsService;

@Configuration
public class UserManagementConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails u = new User("john", "12345", "read");
		List<UserDetails> users = List.of(u);
		return new InMemoryUserDetailsService(users);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
