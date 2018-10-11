package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.pojos.User;

@Service
public interface UserService {

	public User validateUser(User user);
	
	public void createUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUser(int id);
	
}
