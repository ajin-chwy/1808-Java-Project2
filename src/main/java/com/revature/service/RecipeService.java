package com.revature.service;

import java.util.List;

import com.revature.pojos.Recipe;
import com.revature.pojos.User;

public interface RecipeService {
	
	public void createRecipe(Recipe recipe);
	
	public List<Recipe> getAllRecipes();
	
	public Recipe getRecipe(int id);
	
	public List<Recipe> getOwnedRecipes(User user);

	public void hideRecipe(Recipe recipe);
}
