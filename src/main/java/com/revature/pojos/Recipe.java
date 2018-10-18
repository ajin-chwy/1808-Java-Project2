package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RECIPES")
public class Recipe {

	@Id
	@Column(name="RECIPEID")
	@SequenceGenerator(name="RECIPEID_SEQ", sequenceName="RECIPEID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECIPEID_SEQ")
	private int recipeId;
	
	@ManyToOne
	@JoinColumn(name="OWNER")
	private User owner;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="STEPS")
	private String steps;
	
	@Column(name="INGREDIENTS")
	private String ingredients;
	
	@Column(name="SCORE")
	private double score;

	@Column(name="DELETED")
	private boolean deleted;
	
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(name="RIJUNCTION",
//				joinColumns=@JoinColumn(name="RECIPE"),
//				inverseJoinColumns=@JoinColumn(name="INGREDIENT"))
//	private Set<Ingredient> ingredients;
	
//	@OneToMany(mappedBy="targetRecipe", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	private Set<Review> reviews;
	
//	@OneToMany(mappedBy="targetRecipe", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	private Set<Suggestion> suggestions;



	public Recipe() {
		super();
	}

public Recipe(int recipeId, User owner, String name, String steps, String ingredients, double score,
			boolean deleted) {
		super();
		this.recipeId = recipeId;
		this.owner = owner;
		this.name = name;
		this.steps = steps;
		this.ingredients = ingredients;
		this.score = score;
		this.deleted = deleted;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	
	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", owner=" + owner + ", name=" + name + ", steps=" + steps
				+ ", ingredients=" + ingredients + ", score=" + score + ", deleted=" + deleted + "]";
	}

//	public Set<Ingredient> getIngredients() {
//		return ingredients;
//	}
//
//	public void setIngredients(Set<Ingredient> ingredients) {
//		this.ingredients = ingredients;
//	}
//
//	public Set<Review> getReviews() {
//		return reviews;
//	}
//
//	public void setReviews(Set<Review> reviews) {
//		this.reviews = reviews;
//	}
//
//	public Set<Suggestion> getSuggestions() {
//		return suggestions;
//	}
//
//	public void setSuggestions(Set<Suggestion> suggestions) {
//		this.suggestions = suggestions;
//	}

	
	
	
	
}
