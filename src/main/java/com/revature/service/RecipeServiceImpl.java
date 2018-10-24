package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.RecipeDAO;
import com.revature.pojos.Recipe;
import com.revature.pojos.User;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDAO recipeDao;
	
	@Override
	public void createRecipe(Recipe recipe) {
		recipeDao.createRecipe(recipe);
	}

	@Override
	public List<Recipe> getOwnedRecipes(User user) {
		List<Recipe> rList= recipeDao.getAllRecipe();
		List<Recipe> result = new ArrayList<Recipe>();
		for(Recipe r: rList) {
			try {
				if(r.getOwner().getUserId() == user.getUserId()) {
					result.add(r);
				}
			} catch (Exception e) {
				
			}
		}
		return result;
	}

	@Override
	public void hideRecipe(Recipe recipe) {
		recipeDao.updateRecipe(recipe);
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
