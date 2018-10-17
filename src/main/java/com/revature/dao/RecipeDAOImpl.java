package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.revature.pojos.Recipe;
import com.revature.util.SessionUtil;

@Service
public class RecipeDAOImpl implements RecipeDAO {
	
	private Session curr;
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
		curr = SessionUtil.getSession();
		curr.beginTransaction();
		curr.delete(recipe);
		curr.getTransaction().commit();
	}

	@Override
	public void createRecipe(Recipe recipe) {
		curr = SessionUtil.getSession();
		curr.beginTransaction();
		curr.saveOrUpdate(recipe);
		curr.getTransaction().commit();
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		curr = SessionUtil.getSession();
		curr.beginTransaction();
		curr.merge(recipe);
		curr.getTransaction().commit();
	}

}
