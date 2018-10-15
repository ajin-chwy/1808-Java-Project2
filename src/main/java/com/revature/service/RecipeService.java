package com.revature.service;

import java.util.List;

import com.revature.pojos.Recipe;

public interface RecipeService {
	
	public void createRecipe(Recipe recipe);
	
	public List<Recipe> getAllRecipes();
	
	public Recipe getRecipe(int id);
}
