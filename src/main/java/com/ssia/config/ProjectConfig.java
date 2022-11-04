package com.ssia.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic(c -> {
			c.realmName("OTHER");
			c.authenticationEntryPoint(new AuthenticationEntryPoint() {
				@Override
				public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
						throws IOException, ServletException {
					response.addHeader("message", "Luke, I'm your father!");
					response.sendError(HttpStatus.UNAUTHORIZED.value());
				}
			});
		});
		http.authorizeRequests().anyRequest().authenticated();
	}
}
