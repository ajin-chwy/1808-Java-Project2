package com.revature.service;

import org.springframework.stereotype.Service;

import com.revature.pojos.User;

@Service
public interface UserService {

	public User validateUser(User user);
	
	public void createUser(User user);
	
}
