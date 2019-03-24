/**
 * 
 */
package com.uniquemind.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniquemind.user.exception.UserAlreadyFoundException;
import com.uniquemind.user.exception.UserNotFoundException;
import com.uniquemind.user.model.User;
import com.uniquemind.user.service.UserService;

/**
 * @author Nag
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/api/v1/users")
public class UserController {
	
	protected Logger logger = Logger.getLogger(UserController.class.getName());
	
	private UserService userService;
	private ResponseEntity<User> responseEntity;
	
	public UserController() {
	}

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserAlreadyFoundException {
		logger.info("Registering an User");
		try {
			userService.saveUser(user);
			responseEntity = new ResponseEntity<User>(user, HttpStatus.CREATED);
		} catch (UserAlreadyFoundException e) {
			throw new UserAlreadyFoundException();
		}
		return responseEntity;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id) throws UserNotFoundException{
		logger.info("Deleting an User");
		try {
			userService.deleteByUserId(id);
			responseEntity = new ResponseEntity<User>(HttpStatus.OK);
		}
		catch(UserNotFoundException e){
			throw new UserNotFoundException();
		}
		return responseEntity;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findUser(@PathVariable("id")int id) throws UserNotFoundException{
		logger.info("Fetching an User");
		try {
			User fetchedUser = userService.findByUserId(id);
			responseEntity = new ResponseEntity<User>(fetchedUser, HttpStatus.OK);			
		}
		catch(UserNotFoundException e){
			throw new UserNotFoundException();
		}
		return responseEntity;
	}
	
	@GetMapping("/all")
	public List<User> findAllUsers() throws UserNotFoundException{
		logger.info("Fetching all users");
		List<User> users = new ArrayList<User>();
		try {
			users = userService.findAllUsers();
			responseEntity = new ResponseEntity<User>(HttpStatus.ACCEPTED);
		}
		catch(UserNotFoundException e) {
			throw new UserNotFoundException();
		}
		return users;
	}
}
