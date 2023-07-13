package com.exittest.backend.model;

/**
 * @author aryanverma
 * jwtResponse class represents a response containing a JWT token.
 */
public class jwtResponse {
	private String token;

	/**
	 * Constructs an empty jwtResponse object.
	 */
	public jwtResponse() {}

	/**
	 * Constructs a jwtResponse object with the specified token.
	 *
	 * @param token The JWT token.
	 */
	public jwtResponse(String token) {
		super();
		this.token = token;
	}

	/**
	 * Retrieves the JWT token.
	 *
	 * @return The JWT token.
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the JWT token.
	 *
	 * @param token The JWT token.
	 */
	public void setToken(String token) {
		this.token = token;
	}
}
