package com.ust.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.entity.User;
import com.ust.repos.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;

	public void addUser(User user){
		repository.addUser(user);
	}

	public User findUser(int id) {
		return repository.findUser(id);
	}

	public List<User> findUsers() {
		return repository.findUsers();
	}
}
