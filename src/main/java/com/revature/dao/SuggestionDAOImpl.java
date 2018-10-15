package com.revature.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.pojos.Suggestion;
import com.revature.util.SessionUtil;

@Service
public class SuggestionDAOImpl implements SuggestionDAO {

	@Override
	public Suggestion getSuggestion(int id) {
		return SessionUtil.getSession().get(Suggestion.class, id);
	}

	@Override
	public List<Suggestion> getAllSuggestion() {
		return SessionUtil.getSession().createCriteria(Suggestion.class).list();
	}

	@Override
	public void deleteSuggestion(Suggestion suggestion) {
		SessionUtil.getSession().delete(suggestion);
	}

	@Override
	public void createSuggestion(Suggestion suggestion) {
		SessionUtil.getSession().saveOrUpdate(suggestion);
	}

	@Override
	public void updateSuggestion(Suggestion suggestion) {
		SessionUtil.getSession().merge(suggestion);
	}

}
