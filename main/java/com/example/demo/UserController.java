package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService  userService;
	
	@RequestMapping("/users")
		public List<User> getAllUsers() {
		return  userService.getAllUsers();
	}
	
	@RequestMapping("/user")
	public String getAllUser() {
	return "Tendai";
}
	
	@RequestMapping("/users/{id}")
	//getting a specific user by ID
	public User getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	@RequestMapping(value="/users", method= RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		
		userService.addUser(user);
		
	}
	
	@RequestMapping(value="/users/{id}", method= RequestMethod.PUT)
	public void updateUser(@RequestBody User user, @PathVariable String id) {
		
		userService.updateUser(id,user);
		
	}
	
	@RequestMapping(value="/users/{id}", method= RequestMethod.DELETE)
	
	public void deleteUser(@PathVariable String id) {
		 userService.deleteUser(id);
	}
}



