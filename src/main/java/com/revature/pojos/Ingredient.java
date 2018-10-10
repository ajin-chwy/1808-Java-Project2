package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INGREDIENTS")
public class Ingredient {
	
	@Id
	@Column(name="INGREDIENTID")
	@SequenceGenerator(name="INGREDIENTSEQ_ID", sequenceName="INGREDIENTSEQ_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INGREDIENTSEQ_ID")
	private int ingredientId;
	
	@Column(name="TEXT")
	private String text;

	public Ingredient() {
		super();
	}

	//Just a check
	public Ingredient(int ingredientId, String text) {
		super();
		this.ingredientId = ingredientId;
		this.text = text;
	}

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Ingredient [ingredientId=" + ingredientId + ", text=" + text + "]";
	}
	
	
}
