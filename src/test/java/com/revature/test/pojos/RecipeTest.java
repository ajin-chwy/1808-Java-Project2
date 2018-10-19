package com.revature.test.pojos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pojos.Recipe;
import com.revature.pojos.User;

public class RecipeTest {

	private static Recipe recipeTest;
	private static User userTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		userTest = new User(1001, "testing", "safepassword", "cook", "Spongebob", "Squarepants", "555 IQ Lane", false);
		recipeTest = new Recipe(1, userTest, "Ham and Cheese", "Grab the bread, ham, and cheese, and smoosh them together", "ham, bread, cheese", 2, false);
	}

	@After
	public void tearDown() throws Exception {
		userTest = new User(1001, "testing", "safepassword", "cook", "Spongebob", "Squarepants", "555 IQ Lane", false);
		recipeTest = new Recipe(1, userTest, "Ham and Cheese", "Grab the bread, ham, and cheese, and smoosh them together", "ham, bread, cheese", 2, false);
	}
	
	/* TESTS FOR GETTERS */

	@Test
	public void testGetRecipeId() {
		assertEquals("Should return the recipe ID", 1, recipeTest.getRecipeId());
	}
	
	@Test
	public void testGetOwner() {
		assertEquals("Should return the recipe owner", userTest, recipeTest.getOwner());
	}
	
	@Test
	public void testGetName() {
		assertEquals("Should return the recipe name", "Ham and Cheese", recipeTest.getName());
	}
	
	@Test
	public void testGetSteps() {
		assertEquals("Should return the recipes steps", "Grab the bread, ham, and cheese, and smoosh them together", recipeTest.getSteps());
	}
	
	@Test
	public void testGetIngredients() {
		assertEquals("Should return the recipe ingredients", "ham, bread, cheese", recipeTest.getIngredients());
	}
	
	@Test
	public void testGetScore() {
		assertEquals("Should return the recipe score", 2, recipeTest.getScore(),0);
	}
	
	@Test
	public void testGetDeleted() {
		assertEquals("Should return the recipe ingredients", false, recipeTest.isDeleted());
	}
	
	/* TESTS FOR SETTERS */
	@Test
	public void testSetRecipeId() {
		recipeTest.setRecipeId(2);
		assertEquals("Should return the recipe ID", 2, recipeTest.getRecipeId());
	}
	
	@Test
	public void testSetOwner() {
		recipeTest.setOwner(null);
		assertEquals("Should return the recipe owner", null, recipeTest.getOwner());
	}
	
	@Test
	public void testSetName() {
		recipeTest.setName("Cheese and Ham");
		assertEquals("Should return the recipe name", "Cheese and Ham", recipeTest.getName());
	}
	
	@Test
	public void testSetSteps() {
		recipeTest.setSteps("Just eat");
		assertEquals("Should return the recipes steps", "Just eat", recipeTest.getSteps());
	}
	
	@Test
	public void testSetIngredients() {
		recipeTest.setIngredients("cheese and ham");
		assertEquals("Should return the recipe ingredients", "cheese and ham", recipeTest.getIngredients());
	}
	
	@Test
	public void testSetScore() {
		recipeTest.setScore(5);
		assertEquals("Should return the recipe score", 5, recipeTest.getScore(),0);
	}
	
	@Test
	public void testSetDeleted() {
		recipeTest.setDeleted(true);
		assertEquals("Should return the recipe ingredients", true, recipeTest.isDeleted());
	}

}
