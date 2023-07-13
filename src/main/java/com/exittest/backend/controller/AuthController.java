package com.exittest.backend.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.exittest.backend.config.JwtUtils;
import com.exittest.backend.model.User;
import com.exittest.backend.model.JwtRequest;
import com.exittest.backend.model.jwtResponse;
import com.exittest.backend.service.CustomUserDetailService;

/**
 * @author aryanverma
 * Controller class for authentication-related endpoints.
 */

@RestController
@CrossOrigin
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomUserDetailService customUserDetailService;
	@Autowired
	private JwtUtils jwtUtil;
	
	/**
	 * Generates a JWT token for the specified user credentials.
	 *
	 * @param jwtRequest The JWT request containing the username and password.
	 * @return The response entity containing the generated JWT token.
	 * @throws Exception If an exception occurs during token generation or authentication.
	 */
	@PostMapping(value="/api/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		}
		catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Crendetials");
			
		}
		UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtUtil.generateToken(userDetails);
		return  ResponseEntity.ok(new jwtResponse(token));
	}

	/**
	 * Retrieves the current user based on the provided principal.
	 *
	 * @param principal The principal representing the authenticated user.
	 * @return The current user information.
	 */
	@GetMapping("/api/currentuser")
	public User getCurrentUser(Principal principal)
	{
		return ((User)(this.customUserDetailService.loadUserByUsername(principal.getName())));
		
	}
}
