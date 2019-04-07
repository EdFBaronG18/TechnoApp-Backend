package com.web.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping("/getAllUsers")
	public Iterable<User> getAllUsers () {
		return userRepository.findAll();
	}
	
	@RequestMapping(path="/addUser", method=RequestMethod.POST) 
	public @ResponseBody String addNewUser 
	(
			@RequestParam String 	username	, 
			@RequestParam String 	name		,
			@RequestParam String 	password	) {
		
		User newUser = new User(username, name, password);
		userRepository.save(newUser);
		return "Usuario Guardado";
	}
	
	@RequestMapping(path="/getUserById", method=RequestMethod.POST) 
	public @ResponseBody User getUserById
	(
			@RequestParam Long id) {
		return userRepository.findById(id).get();
	}
	
	public @ResponseBody User getUserByUsername
	(
			@RequestParam String username) {
		return userRepository.findByUsername(username);
	}
	
	
	@RequestMapping(path="/validatedUser", method=RequestMethod.GET)
	public @ResponseBody User validatedUser 
	(
			@RequestHeader String username,
			@RequestHeader String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
	
}
