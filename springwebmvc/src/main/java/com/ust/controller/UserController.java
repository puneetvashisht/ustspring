package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ust.entity.User;
import com.ust.execeptions.UserNotFoundException;
import com.ust.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET )
	public User getUser(@PathVariable("id") int id){
		User findUser = service.findUser(id);
		if(findUser == null) throw new UserNotFoundException("User not found!!");
		return findUser;
//		return new User(12, "Ravi");
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value="/user", method=RequestMethod.POST )
	public void addUser(@RequestBody User user){
		System.out.println("some business logic");
		System.out.println(user);
		service.addUser(user);
//		return service.findUser(id);
//		return new User(12, "Ravi");
	}
	@RequestMapping("/users")
	public List<User> getUsers(){
		return service.findUsers();
	}

}
