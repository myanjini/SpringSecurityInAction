package com.ssia.filters;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.csrf.CsrfToken;

public class CsrfTokenLogger implements Filter {
	private Logger logger = Logger.getLogger(CsrfTokenLogger.class.getName());
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Object o = request.getAttribute("_csrf");
		CsrfToken token = (CsrfToken) o;
		
		logger.info("CSRF token " + token.getToken());
		logger.info(
			String.format("curl -XPOST -v %s -H \"Cookie: %s\" -H \"X-CSRF-TOKEN: %s\"",
				"http://localhost:8080/hello",
				"JSESSIONID=" + ((HttpServletRequest) request).getSession().getId(), 
				token.getToken()));
				
		chain.doFilter(request, response);		
	}
}
