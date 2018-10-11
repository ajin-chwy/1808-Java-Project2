package com.revature.dao;

import java.util.List;

import com.revature.pojos.User;

public interface UserDAO {
	public User getUser(int id);
	
	public List<User> getAllUser();
	
	public void deleteUser(User use);
	
	public void createUser(User use);
	
	public void updateUser(User use);
}
