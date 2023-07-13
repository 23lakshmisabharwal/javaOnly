package com.exittest.backend.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
/**
 * @author aryanverma
 * UserRole class represents the association between a User and a Role.
 */
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userRoleId;
	
	// User associated with the role
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	// Role associated with the user
	@ManyToOne
	private Role role;

	/**
	 * Retrieves the user role ID.
	 *
	 * @return The user role ID.
	 */
	public Long getUserRoleId() {
		return userRoleId;
	}

	/**
	 * Sets the user role ID.
	 *
	 * @param userRoleId The user role ID.
	 */
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * Retrieves the user associated with the role.
	 *
	 * @return The user associated with the role.
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user associated with the role.
	 *
	 * @param user The user associated with the role.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Retrieves the role associated with the user.
	 *
	 * @return The role associated with the user.
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role associated with the user.
	 *
	 * @param role The role associated with the user.
	 */
	public void setRole(Role role) {
		this.role = role;
	}
}
