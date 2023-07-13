package com.exittest.backend.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exittest.backend.service.CustomUserDetailService;

/**
 * @author aryanverma
 * Filter to handle authentication for incoming requests.
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	
	@Autowired
	private CustomUserDetailService customUserDetailsService;
	@Autowired
	private JwtUtils jwtUtils;
	
	/**
	 * Filters incoming requests and handles authentication.
	 *
	 * @param request The incoming HTTP request.
	 * @param response The outgoing HTTP response.
	 * @param filterChain The filter chain for handling subsequent filters.
	 * @throws ServletException If an exception occurs during the filter process.
	 * @throws IOException If an I/O exception occurs during the filter process.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String requestTokenHeader =request.getHeader("Authorization");
		String username=null;
		String jwtToken=null;

		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken=requestTokenHeader.substring(7);
 
			try {
				
				username=jwtUtils.extractUsername(jwtToken);

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		//Security
		UserDetails userDetials=this.customUserDetailsService.loadUserByUsername(username);
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetials,null,userDetials.getAuthorities());
			
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);		
		}
		else
		{
			System.out.println("Token is not validated...");
		}
		}
	
		filterChain.doFilter(request,response);
	}
}
