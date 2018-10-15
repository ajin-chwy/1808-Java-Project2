package com.revature.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.pojos.Recipe;
import com.revature.util.SessionUtil;

@Service
public class RecipeDAOImpl implements RecipeDAO {
	
	@Override
	public Recipe getRecipe(int id) {
		return SessionUtil.getSession().get(Recipe.class,  id);
	}

	@Override
	public List<Recipe> getAllRecipe() {
		return SessionUtil.getSession().createCriteria(Recipe.class).list();
	}

	@Override
	public void deleteRecipe(Recipe recipe) {
		SessionUtil.getSession().delete(recipe);
	}

	@Override
	public void createRecipe(Recipe recipe) {
		SessionUtil.getSession().saveOrUpdate(recipe);
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		SessionUtil.getSession().merge(recipe);
	}

}
