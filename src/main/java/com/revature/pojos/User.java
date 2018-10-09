package com.revature.pojos;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
	private int userId;
	
	private String role;
	
	private String fName;
	
	private String lName;
	
	private String address;
	
	private boolean deleted;
	
	private Set<Recipe> savedRecipes;
	
	private Set<Recipe> ownedRecipes;
}
