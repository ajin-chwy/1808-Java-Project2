package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojos.Recipe;
import com.revature.pojos.User;
import com.revature.service.RecipeService;
import com.revature.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/recipe", method=RequestMethod.GET, produces="application/json")
	public List<Recipe> recipeGetAll(HttpSession sess) {
		System.out.println("In recipeGetAll");
		return recipeService.getAllRecipes();
	}
	
	@RequestMapping(value="/recipe/{id}", method=RequestMethod.GET, produces="application/json")
	public Recipe recipeGet (HttpSession sess, @PathVariable(value="id") Integer id) {
		System.out.println("In recipeGet");
		return recipeService.getRecipe(id);
	}
	
	@RequestMapping(value="/recipe", method=RequestMethod.POST, produces="application/json", consumes= {"application/json"})
	public void createRecipe(@RequestBody Recipe recipe, HttpSession sess) {
		System.out.println("in recipePost");
		System.out.println(recipe);
		recipeService.createRecipe(recipe);
	}
	
	@RequestMapping(value="/recipe/{id}", method=RequestMethod.POST, produces="application/json", consumes= {"application/json"})
	public User addSavedRecipe(@PathVariable(value="id") Integer id, @RequestBody Recipe recipe) {
		User authUser = userService.getUser(id);
		userService.addSavedRecipe(authUser, recipe);
		return authUser;
	}
	
	@RequestMapping(value="/recipe/{id}", method=RequestMethod.PUT, produces="application/json", consumes= {"application/json"})
	public User removeSavedRecipe(@PathVariable(value="id") Integer id, @RequestBody Recipe recipe) {
		User authUser = userService.getUser(id);
		userService.removeSavedRecipe(authUser, recipe);
		return authUser;
	}
}
