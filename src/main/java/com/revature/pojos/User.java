package com.revature.pojos;

import java.util.HashSet;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@Column(name="USERID")
	@SequenceGenerator(name="USERID_SEQ", sequenceName="USERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERID_SEQ")
	private int userId;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;

	@Column(name="ROLE")
	private String role;
	
	@Column(name="FNAME")
	private String fName;
	
	@Column(name="LNAME")
	private String lName;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="DELETED")
	private boolean deleted;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="SAVEDRECIPES",
			joinColumns=@JoinColumn(name="USERID"),
			inverseJoinColumns=@JoinColumn(name="RECIPEID"))
	private Set<Recipe> savedRecipes = new HashSet<Recipe>();
	
//	@OneToMany(mappedBy="owner", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	private Set<Recipe> ownedRecipes = new HashSet<Recipe>();

	public User() {
		super();
	}

	public void addSavedRecipe(Recipe rec) {
		this.savedRecipes.add(rec);
	}
	
	public void removeSavedRecipe(Recipe rec) {
		for (Recipe r: this.savedRecipes) {
			if(r.getRecipeId() == rec.getRecipeId()) {
				this.savedRecipes.remove(r);
			}
		}
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public User(int userId, String username, String password, String role, String fName, String lName, String address,
			boolean deleted) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", fName=" + fName + ", lName=" + lName + ", address=" + address + ", deleted=" + deleted
				+ "]";
	}
	
	

	public Set<Recipe> getSavedRecipes() {
		return savedRecipes;
	}

	public void setSavedRecipes(Set<Recipe> savedRecipes) {
		this.savedRecipes = savedRecipes;
	}

//	public Set<Recipe> getOwnedRecipes() {
//		return ownedRecipes;
//	}
//
//	public void setOwnedRecipes(Set<Recipe> ownedRecipes) {
//		this.ownedRecipes = ownedRecipes;
//	}

	
	
}
