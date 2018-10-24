package com.revature.service;

import java.util.List;

import com.revature.pojos.Recipe;
import com.revature.pojos.User;

public interface UserService {

	public User validateUser(User user);
	
	public void createUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUser(int id);
	
	public void addSavedRecipe(User use, Recipe rec);
	
	public void removeSavedRecipe(User use, Recipe rec);
	
}
