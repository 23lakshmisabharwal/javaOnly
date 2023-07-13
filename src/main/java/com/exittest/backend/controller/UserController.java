package com.exittest.backend.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exittest.backend.model.Role;
import com.exittest.backend.model.User;
import com.exittest.backend.model.UserRole;
import com.exittest.backend.service.UserService;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * @author aryanverma
 * Controller class for handling user-related operations.
 */
@RequestMapping("/api")
@RestController 
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String find()
	{
		return "This is user API";
	}
	/**
	 * Registers a new user.
	 *
	 * @param user The user to register.
	 * @return The response entity indicating the success of the registration.
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody User user) 
	{
	Set<UserRole> roles=new HashSet<>();
	Role role=new Role();
	role.setRoleName("USER");
	role.setRoleId(45L);
	UserRole userRole=new UserRole();
	userRole.setRole(role);
	userRole.setUser(user);
	roles.add(userRole);
		
	String bcryptHashString = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
	user.setPassword(bcryptHashString);

	User createUser = userService.addUser(user,roles);

	if (createUser == null) {

		return ResponseEntity.status(401).build();
	} else {
		return ResponseEntity.status(200).build();
	}
		
	}
	/**
	 * Retrieves a user by username.
	 *
	 * @param username The username of the user to retrieve.
	 * @return The user with the specified username.
	 */
	@GetMapping("/{username}")
	public User getuserByname(@PathVariable String username)
	{
		return this.userService.getUserByUserName(username);
	}

	/**
	 * Retrieves all users.
	 *
	 * @return The list of all users.
	 */
	@GetMapping("/user")
	public List<User> getallUser(){
		return this.userService.getAllUser();
	}
	/**
	 * Retrieves the number of users.
	 *
	 * @return The number of users.
	 */
	@GetMapping("/count-users")
	public Long getUser()
	{
		return this.userService.getCountUser();
	}
	
	
	
}
