package com.exittest.backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
/**
 * @author aryanverma
 * Role class represents a user role entity.
 */
public class Role {
	@Id
	private Long roleId;
	private String roleName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	private Set<UserRole> userRoles = new HashSet<>();

	public Role() {}

	/**
	 * Constructs a Role object with the specified role ID and role name.
	 *
	 * @param roleId   The ID of the role.
	 * @param roleName The name of the role.
	 */
	public Role(Long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	/**
	 * Retrieves the ID of the role.
	 *
	 * @return The ID of the role.
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * Sets the ID of the role.
	 *
	 * @param roleId The ID of the role.
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * Retrieves the name of the role.
	 *
	 * @return The name of the role.
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets the name of the role.
	 *
	 * @param roleName The name of the role.
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Retrieves the set of user roles associated with this role.
	 *
	 * @return The set of user roles associated with this role.
	 */
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	/**
	 * Sets the set of user roles associated with this role.
	 *
	 * @param userRoles The set of user roles associated with this role.
	 */
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}
