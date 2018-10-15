package com.revature.dao;

import java.util.List;

import com.revature.pojos.Recipe;

public interface RecipeDAO {
	public Recipe getRecipe(int id);
	
	public List<Recipe> getAllRecipe();
	
	public void deleteRecipe(Recipe recipe);
	
	public void createRecipe(Recipe recipe);
	
	public void updateRecipe(Recipe recipe);
}
