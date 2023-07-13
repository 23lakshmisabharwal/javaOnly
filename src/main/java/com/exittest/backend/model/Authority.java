package com.exittest.backend.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author aryanverma
 * Authority class representing a granted authority for a user.
 */
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	private String authority;

	/**
	 * Constructs an Authority object with the specified authority.
	 *
	 * @param authority The authority granted to the user.
	 */
	public Authority(String authority) {
		this.authority = authority;
	}

	/**
	 * Retrieves the authority.
	 *
	 * @return The authority granted to the user.
	 */
	@Override
	public String getAuthority() {
		return this.authority;
	}

}
