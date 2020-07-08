package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.User;

@Service
public class UserService {

	private List <User> users= new ArrayList<>(Arrays.asList(
			new User("1","Tendai","Mamini","tendaimamini@gmail.com","5467 nkwisi gardens"),
			new User("2","Loyce","Kufa","loycekufa@gmail.com","34 coronation avenue greendale"),
			new User("3","Nozipho","Ndlovu","nozzy@gmail.com","181 elizabeth windsor marlborough"),
			new User("4","Patrick","Ndlovu","robertndlovu@gmail.com","Chitungwiza")
			));
	
	public List<User> getAllUsers(){
		//List<User> users = new ArrayList<>();
		
		return users;
		
	}
	
	public User getUser(String id) {
		return  users.stream().filter(u -> u.getId().equals(id)).findFirst().get();
	  }
	
	public void addUser(User user) {
		
		users.add(user);
		
	}
	
	public void updateUser(String id, User user) {
		//loop through all the users and get the one with specific id then update
		
		for(int i=0; i<users.size(); i++) {
			User u = users.get(i);
			if(u.getId().equals(id)) {
				users.set(i,user);
				return;
			} 
		}
		
		
		
	}
	
	public void deleteUser(String id) {
		users.removeIf(u -> u.getId().equals(id)); // without crud
		
		//userRepository.deleteById(id);
	}
}
