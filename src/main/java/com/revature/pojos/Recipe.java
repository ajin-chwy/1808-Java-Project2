package com.revature.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToOne
	@JoinColumn(name="USERID")
	private User owner;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="STEPS")
	private String steps;
	
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

//	public Recipe(int recipeId, User owner, String name, String steps, boolean deleted, Set<Ingredient> ingredients,
//			Set<Review> reviews, Set<Suggestion> suggestions) {
//		super();
//		this.recipeId = recipeId;
//		this.owner = owner;
//		this.name = name;
//		this.steps = steps;
//		this.deleted = deleted;
//		this.ingredients = ingredients;
//		this.reviews = reviews;
//		this.suggestions = suggestions;
//	}

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

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", owner=" + owner + ", name=" + name + ", steps=" + steps
				+ ", deleted=" + deleted + "]";
	}

	public Recipe(int recipeId, User owner, String name, String steps, boolean deleted) {
		super();
		this.recipeId = recipeId;
		this.owner = owner;
		this.name = name;
		this.steps = steps;
		this.deleted = deleted;
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
//
//	@Override
//	public String toString() {
//		return "Recipe [recipeId=" + recipeId + ", owner=" + owner + ", name=" + name + ", steps=" + steps
//				+ ", deleted=" + deleted + ", ingredients=" + ingredients + ", reviews=" + reviews + ", suggestions="
//				+ suggestions + "]";
//	}
	
	
	
	
}
