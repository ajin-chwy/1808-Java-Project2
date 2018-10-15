package com.revature.dao;

import java.util.List;

import com.revature.pojos.Ingredient;

public interface IngredientDAO {

	public Ingredient getIngredient(int id);
	
	public List<Ingredient> getAllIngredient();
	
	public void deleteIngredient(Ingredient ingredient);
	
	public void createIngredient(Ingredient ingredient);
	
	public void updateIngredient(Ingredient ingredient);
}
