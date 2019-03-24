/**
 * 
 */
package com.uniquemind.user.service;

import java.util.List;

import com.uniquemind.user.exception.UserAlreadyFoundException;
import com.uniquemind.user.exception.UserNotFoundException;
import com.uniquemind.user.model.User;

/**
 * @author Nag
 *
 */
public interface UserService {
	
	User saveUser(User user) throws UserAlreadyFoundException;
	User findByUserId(int id) throws UserNotFoundException;
	void deleteByUserId(int id) throws UserNotFoundException;
	List<User> findAllUsers() throws UserNotFoundException;

}
