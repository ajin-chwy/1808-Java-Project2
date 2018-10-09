package com.revature.pojos;

import java.util.Set;

public class Recipe {

	private int recipeId;
	
	private User owner;
	
	private String name;
	
	private String text;
	
	private boolean deleted;
	
	private Set<Ingredient> ingredients;
	
	private Set<Review> reviews;
	
	private Set<Suggestion> suggestions;
}
