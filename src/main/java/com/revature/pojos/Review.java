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
@Table(name="REVIEWS")
public class Review {

	@Id
	@Column(name="REVIEWID")
	@SequenceGenerator(name="REVIEWID_SEQ", sequenceName="REVIEWID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REVIEWID_SEQ")
	private int reviewId;
	
	@ManyToOne
	@JoinColumn(name="RECIPESID")
	private Recipe targetRecipe;
	
	@Column(name="SCORE")
	private int score;
	
	@Column(name="MESSAGE")
	private String message;

	public Review() {
		super();
	}

	public Review(int reviewId, Recipe targetRecipe, int score, String message) {
		super();
		this.reviewId = reviewId;
		this.targetRecipe = targetRecipe;
		this.score = score;
		this.message = message;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Recipe getTargetRecipe() {
		return targetRecipe;
	}

	public void setTargetRecipe(Recipe targetRecipe) {
		this.targetRecipe = targetRecipe;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", targetRecipe=" + targetRecipe + ", score=" + score + ", message="
				+ message + "]";
	}
	
	
	
	
	
}
