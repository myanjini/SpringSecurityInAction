package com.ssia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ssia.handlers.CustomAuthenticationSuccessHandler;
import com.ssia.handlers.CustomerAuthenticationFailureHandler;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired
	CustomerAuthenticationFailureHandler customerAuthenticationFailureHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.successHandler(customAuthenticationSuccessHandler)
			.failureHandler(customerAuthenticationFailureHandler)
		.and()
			.httpBasic();
		http.authorizeRequests().anyRequest().authenticated();
	}
}
