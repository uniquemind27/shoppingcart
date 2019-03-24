/**
 * 
 */
package com.uniquemind.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquemind.user.exception.UserAlreadyFoundException;
import com.uniquemind.user.exception.UserNotFoundException;
import com.uniquemind.user.model.User;
import com.uniquemind.user.repository.UserRepository;

/**
 * @author Nag
 *
 */
@Service	
public class UserServiceImpl implements UserService{

	public UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) throws UserAlreadyFoundException {
		return userRepository.save(user);
	}

	@Override
	public User findByUserId(int id) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(id);
		
		if(!optional.isPresent()) {
			throw new UserNotFoundException();
		}
		return optional.get();
	}

	@Override
	public void deleteByUserId(int id) throws UserNotFoundException {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> findAllUsers() throws UserNotFoundException{
		return userRepository.findAll();
	}
	
	

}
