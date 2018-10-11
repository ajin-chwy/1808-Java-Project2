package com.revature.service;

import com.revature.pojos.User;

public interface UserService {

	public User validateUser(User user);
	
	public void createUser(User user);
	
}
