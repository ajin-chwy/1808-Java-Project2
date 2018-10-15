package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.RecipeDAO;
import com.revature.pojos.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDAO recipeDao;
	
	@Override
	public void createRecipe(Recipe recipe) {
		recipeDao.createRecipe(recipe);
	}

	@Override
	public List<Recipe> getAllRecipes() {
		return recipeDao.getAllRecipe();
	}

	@Override
	public Recipe getRecipe(int id) {
		return recipeDao.getRecipe(id);
	}

}
