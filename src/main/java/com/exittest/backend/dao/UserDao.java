package com.exittest.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exittest.backend.model.User;

/**
 * @author aryanverma
 * UserDao is a repository interface for performing CRUD operations on User entities.
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	/**
	 * Retrieve a user by username and password.
	 *
	 * @param username the username of the user
	 * @param password the password of the user
	 * @return the user with the specified username and password, or null if not found
	 */
	public User findByUsernameAndPassword(String username, String password);

	/**
	 * Retrieve a user by username.
	 *
	 * @param userName the username of the user
	 * @return the user with the specified username, or null if not found
	 */
	public User findByUsername(String userName);
}
