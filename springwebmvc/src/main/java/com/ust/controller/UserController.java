package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.entity.User;
import com.ust.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET )
	public User getUser(@PathVariable("id") int id){
		return service.findUser(id);
//		return new User(12, "Ravi");
	}

}
