package com.revature.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.pojos.Review;
import com.revature.util.SessionUtil;

@Service
public class ReviewDAOImpl implements ReviewDAO {

	@Override
	public Review getReview(int id) {
		return SessionUtil.getSession().get(Review.class, id);
	}

	@Override
	public List<Review> getAllReview() {
		return SessionUtil.getSession().createCriteria(Review.class).list();
	}

	@Override
	public void deleteReview(Review review) {
		SessionUtil.getSession().delete(review);
	}

	@Override
	public void createReview(Review review) {
		SessionUtil.getSession().saveOrUpdate(review);
	}

	@Override
	public void updateReview(Review review) {
		SessionUtil.getSession().merge(review);
	}

}
