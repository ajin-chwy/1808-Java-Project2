package com.revature.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.pojos.Ingredient;
import com.revature.util.SessionUtil;

@Service
public class IngredientDAOImpl implements IngredientDAO {
	
	@Override
	public Ingredient getIngredient(int id) {
		return SessionUtil.getSession().get(Ingredient.class, id);
	}

	@Override
	public List<Ingredient> getAllIngredient() {
		return SessionUtil.getSession().createCriteria(Ingredient.class).list();
	}

	@Override
	public void deleteIngredient(Ingredient ingredient) {
		SessionUtil.getSession().delete(ingredient);
	}

	@Override
	public void createIngredient(Ingredient ingredient) {
		SessionUtil.getSession().saveOrUpdate(ingredient);
	}

	@Override
	public void updateIngredient(Ingredient ingredient) {
		SessionUtil.getSession().merge(ingredient);
	}

}
