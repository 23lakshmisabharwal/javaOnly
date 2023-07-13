package com.exittest.backend.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
/**
 * @author aryanverma
 * User class represents a user entity.
 */
public class User implements UserDetails {
	/**
	 * Serial version UID for User serialization.
	 */
	private static final long serialVersionUID = 1L;

	public User() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	// User has many roles
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();
	
	/**
	 * Constructs a User object with the specified parameters.
	 *
	 * @param id         The ID of the user.
	 * @param firstName  The first name of the user.
	 * @param lastName   The last name of the user.
	 * @param username   The username of the user.
	 * @param password   The password of the user.
	 * @param userRoles  The set of user roles associated with the user.
	 */
	public User(int id, String firstName, String lastName, String username, String password, Set<UserRole> userRoles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.userRoles = userRoles;
	}
	
	/**
	 * Retrieves the ID of the user.
	 *
	 * @return The ID of the user.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the ID of the user.
	 *
	 * @param id The ID of the user.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Retrieves the first name of the user.
	 *
	 * @return The first name of the user.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name of the user.
	 *
	 * @param firstName The first name of the user.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Retrieves the last name of the user.
	 *
	 * @return The last name of the user.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name of the user.
	 *
	 * @param lastName The last name of the user.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Retrieves the username of the user.
	 *
	 * @return The username of the user.
	 */
	public String getUserName() {
		return username;
	}
	
	/**
	 * Sets the username of the user.
	 *
	 * @param userName The username of the user.
	 */
	public void setUserName(String userName) {
		this.username = userName;
	}
	
	/**
	 * Retrieves the password of the user.
	 *
	 * @return The password of the user.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password of the user.
	 *
	 * @param password The password of the user.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Retrieves the set of user roles associated with the user.
	 *
	 * @return The set of user roles associated with the user.
	 */
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	
	/**
	 * Sets the set of user roles associated with the user.
	 *
	 * @param userRoles The set of user roles associated with the user.
	 */
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", userRoles=" + userRoles + "]";
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> set = new HashSet<>();
		this.userRoles.forEach(userRole -> {
			System.out.println(userRole.getRole().getRoleName());
			set.add(new Authority(userRole.getRole().getRoleName()));
		});
		return set;
	}
	
	@Override
	public String getUsername() {
		return getUserName();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}
