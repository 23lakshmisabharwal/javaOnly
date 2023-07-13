package com.exittest.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exittest.backend.dao.UserDao;
import com.exittest.backend.model.User;

@Service
/**
 * @author aryanverma
 * CustomUserDetailService is a custom implementation of the UserDetailsService interface.
 * It provides a method to load user details based on the username.
 */
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	/**
	 * Loads user details by username.
	 *
	 * @param username The username of the user.
	 * @return User details for the specified username.
	 * @throws UsernameNotFoundException If no user is found for the given username.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user found");
		}
		return user;
	}
}
