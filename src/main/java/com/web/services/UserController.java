package com.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.entities.User;
import com.web.repositories.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	// Get All Users
	@RequestMapping("/getAllUsers")
	@CrossOrigin
	public Iterable<User> getAllUsers () {
		return userRepository.findAll();
	}
	
	// Add New User
	@RequestMapping(path="/addUser", method=RequestMethod.POST)
	@CrossOrigin
	public @ResponseBody String addNewUser 
	(
			@RequestParam String 	username	, 
			@RequestParam String 	name		,
			@RequestParam String 	password	) {
		
		User newUser = new User(username, name, password);
		userRepository.save(newUser);
		return "User Saved";
	}
	
	// Get User By Id
	@RequestMapping(path="/getUserById", method=RequestMethod.POST)
	@CrossOrigin
	public @ResponseBody User getUserById
	(
			@RequestParam Long id) {
		return userRepository.findById(id).get();
	}
	
	// Get User By Username
	@RequestMapping(path="/getUserByUsername", method=RequestMethod.POST)
	@CrossOrigin
	public @ResponseBody User getUserByUsername
	(
			@RequestParam String username) {
		return userRepository.findByUsername(username);
	}
	
	
	// Validate User
	@RequestMapping(path="/validatedUser", method=RequestMethod.GET)
	@CrossOrigin
	public @ResponseBody User validatedUser 
	(
			@RequestHeader String username,
			@RequestHeader String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
}
