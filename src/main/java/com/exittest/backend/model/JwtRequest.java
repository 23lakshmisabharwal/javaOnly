package com.exittest.backend.model;

/**
 * @author aryanverma
 * JwtRequest class represents a request for JWT authentication.
 */
public class JwtRequest {
	private String username;
	private String password;

	/**
	 * Constructs an empty JwtRequest object.
	 */
	public JwtRequest() {}

	/**
	 * Constructs a JwtRequest object with the specified username and password.
	 *
	 * @param username The username for authentication.
	 * @param password The password for authentication.
	 */
	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * Retrieves the username.
	 *
	 * @return The username for authentication.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username The username for authentication.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Retrieves the password.
	 *
	 * @return The password for authentication.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password The password for authentication.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
