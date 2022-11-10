package com.ssia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import com.ssia.repository.CustomCsrfTokenRepository;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public CsrfTokenRepository customTokenRepository() {
		return new CustomCsrfTokenRepository();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf(c -> { 
			c.csrfTokenRepository(customTokenRepository());
			c.ignoringAntMatchers("/ciao");
		});
		http.authorizeRequests().anyRequest().permitAll();
	}
}
