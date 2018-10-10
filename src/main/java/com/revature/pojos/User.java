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
	private Set<Recipe> savedRecipes;
	
	@OneToMany(mappedBy="owner", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Recipe> ownedRecipes;

	public User() {
		super();
	}

	public User(int userId, String role, String fName, String lName, String address, boolean deleted,
			Set<Recipe> savedRecipes, Set<Recipe> ownedRecipes) {
		super();
		this.userId = userId;
		this.role = role;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.deleted = deleted;
		this.savedRecipes = savedRecipes;
		this.ownedRecipes = ownedRecipes;
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

	public Set<Recipe> getSavedRecipes() {
		return savedRecipes;
	}

	public void setSavedRecipes(Set<Recipe> savedRecipes) {
		this.savedRecipes = savedRecipes;
	}

	public Set<Recipe> getOwnedRecipes() {
		return ownedRecipes;
	}

	public void setOwnedRecipes(Set<Recipe> ownedRecipes) {
		this.ownedRecipes = ownedRecipes;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", role=" + role + ", fName=" + fName + ", lName=" + lName + ", address="
				+ address + ", deleted=" + deleted + ", savedRecipes=" + savedRecipes + ", ownedRecipes=" + ownedRecipes
				+ "]";
	}
	
	
}
