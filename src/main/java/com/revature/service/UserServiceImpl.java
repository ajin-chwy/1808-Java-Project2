package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDAO;
import com.revature.pojos.Recipe;
import com.revature.pojos.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao;
	@Autowired
	private RecipeService recipeService;
	
	@Override
	public User validateUser(User user) {
		if(user == null) {
			return null;
		}
		for(User u: userDao.getAllUser()) {
			if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
				return u;
			}
		}
		return null;
	}

	@Override
	public void addSavedRecipe(User use, Recipe rec) {
		use.addSavedRecipe(recipeService.getRecipe(rec.getRecipeId()));
		System.out.println("adding savedRecipe: " + rec);
		userDao.updateUser(use);
	}

	@Override
	public void removeSavedRecipe(User use, Recipe rec) {
		use.removeSavedRecipe(rec);
		userDao.updateUser(use);
	}

	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUser();
	}

	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}

}
