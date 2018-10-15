package com.revature.dao;

import java.util.List;

import com.revature.pojos.Review;

public interface ReviewDAO {
	
	public Review getReview(int id);
	
	public List<Review> getAllReview();
	
	public void deleteReview(Review review);
	
	public void createReview(Review review);
	
	public void updateReview(Review review);

}
