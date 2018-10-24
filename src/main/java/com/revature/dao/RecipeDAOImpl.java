package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.revature.pojos.Recipe;
import com.revature.util.SessionUtil;

@Service
public class RecipeDAOImpl implements RecipeDAO {
	
	private static Session curr = SessionUtil.getSession();
	@Override
	public Recipe getRecipe(int id) {
		Recipe recipe = curr.get(Recipe.class, id);
		return recipe;
	}

	@Override
	public List<Recipe> getAllRecipe() {
		return curr.createCriteria(Recipe.class).list();
	}

	@Override
	public void deleteRecipe(Recipe recipe) {
		curr.beginTransaction();
		curr.delete(recipe);
		curr.getTransaction().commit();
	}

	@Override
	public void createRecipe(Recipe recipe) {
		curr.beginTransaction();
		curr.saveOrUpdate(recipe);
		curr.getTransaction().commit();
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		curr.beginTransaction();
		curr.merge(recipe);
		curr.getTransaction().commit();
	}

}
