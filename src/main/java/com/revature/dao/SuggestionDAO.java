package com.revature.dao;

import java.util.List;

import com.revature.pojos.Suggestion;

public interface SuggestionDAO {

	public Suggestion getSuggestion(int id);
	
	public List<Suggestion> getAllSuggestion();
	
	public void deleteSuggestion(Suggestion suggestion);
	
	public void createSuggestion(Suggestion suggestion);
	
	public void updateSuggestion(Suggestion suggestion);
}
