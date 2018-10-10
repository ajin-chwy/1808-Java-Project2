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
@Table(name="SUGGESTIONS")
public class Suggestion {

	@Id
	@Column(name="SUGGESTID")
	@SequenceGenerator(name="SUGGESTIONSEQ_ID", sequenceName="SUGGESTIONSEQ_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SUGGESTIONSEQ_ID")
	private int suggestionId;
	
	@ManyToOne
	@JoinColumn(name="RECIPEID")
	private Recipe targetRecipe;
	
	@Column(name="TEXT")
	private String message;

	public Suggestion() {
		super();
	}

	public Suggestion(int suggestionId, Recipe targetRecipe, String message) {
		super();
		this.suggestionId = suggestionId;
		this.targetRecipe = targetRecipe;
		this.message = message;
	}

	public int getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(int suggestionId) {
		this.suggestionId = suggestionId;
	}

	public Recipe getTargetRecipe() {
		return targetRecipe;
	}

	public void setTargetRecipe(Recipe targetRecipe) {
		this.targetRecipe = targetRecipe;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Suggestion [suggestionId=" + suggestionId + ", targetRecipe=" + targetRecipe + ", message=" + message
				+ "]";
	}
}
