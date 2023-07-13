package com.exittest.backend.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
/**
 * @author aryanverma
 * Custom authentication entry point for handling unauthorized requests.
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	/**
	 * Commences the authentication process for unauthorized requests.
	 *
	 * @param request The HTTP request that resulted in an authentication exception.
	 * @param response The HTTP response to be sent back to the client.
	 * @param authException The authentication exception that occurred during the authentication process.
	 * @throws IOException If an I/O exception occurs during the handling of the unauthorized request.
	 * @throws ServletException If a servlet exception occurs during the handling of the unauthorized request.
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"UnAuthorized : Server");
		
	}

}
