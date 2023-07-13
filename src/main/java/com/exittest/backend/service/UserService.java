package com.exittest.backend.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exittest.backend.dao.RoleDao;
import com.exittest.backend.dao.UserDao;
import com.exittest.backend.model.User;
import com.exittest.backend.model.UserRole;

@Service
/**
 * @author aryanverma
 * UserService is a service class that provides methods to manage users.
 */
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	/**
	 * Retrieves all users.
	 *
	 * @return A list of all users.
	 */
	public List<User> getAllUser() {
		return this.userDao.findAll();
	}

	/**
	 * Retrieves a user by their username.
	 *
	 * @param userName The username of the user to retrieve.
	 * @return The user with the specified username.
	 */
	public User getUserByUserName(String userName) {
		User user = this.userDao.findByUsername(userName);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	/**
	 * Adds a new user.
	 *
	 * @param user       The user to be added.
	 * @param userRoles  The set of user roles to be assigned to the user.
	 * @return The added user.
	 */
	public User addUser(User user, Set<UserRole> userRoles) {
		User userName = this.userDao.findByUsername(user.getUserName());
		if (userName != null) {
			return null;
		}
		for (UserRole ur : userRoles) {
			this.roleDao.save(ur.getRole());
		}
		user.getUserRoles().addAll(userRoles);
		this.userDao.save(user);
		return user;
	}

	/**
	 * Retrieves a user by their username and password.
	 *
	 * @param userName The username of the user.
	 * @param password The password of the user.
	 * @return The user with the specified username and password.
	 */
	public User getUsertByUsernameAndPassword(String userName, String password) {
		User user = this.userDao.findByUsernameAndPassword(userName, password);
		if (user == null) {
			return null;
		}
		return user;
	}

	/**
	 * Gets the total number of users.
	 *
	 * @return The total number of users.
	 */
	public Long getCountUser() {
		return this.userDao.count();
	}

}
