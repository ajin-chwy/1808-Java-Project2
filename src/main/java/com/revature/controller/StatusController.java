package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojos.Recipe;
import com.revature.pojos.User;
import com.revature.service.RecipeService;
import com.revature.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@SessionAttributes("user")
@RequestMapping(value="/status")
public class StatusController {
	
	private User user = null;
	@Autowired
	private UserService userService;
	@Autowired
	private RecipeService recipeService;
	
	@GetMapping(produces="application/json")
	public User getCurrUser() {
		return this.user;
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public List<Recipe> getOwnedRecipes(@PathVariable("id") Integer id) {
		return recipeService.getOwnedRecipes(userService.getUser(id));
	}
	
	@PostMapping(produces="application/json", consumes={"application/json"})
	public User setCurrStatus(@RequestBody User use) {
		this.user = userService.validateUser(use);
		return this.user;
	}
	
	@PutMapping(produces="application/json")
	public User logout() {
		this.user = null;
		return null;
	}
//	@RequestMapping(value="/status", method=RequestMethod.GET, produces="application/json")
//	public User checkStatus(HttpSession sess, User use) {
//		User authUser = use;
//		try {
//			authUser = (User) sess.getAttribute("user");
//			System.out.println("current session? " + sess.getAttribute("user"));
//		} catch (Exception e) {
//			System.out.println("no session created");
//		}
//		return authUser;
//	}
//	
//	@RequestMapping(value="/status", method=RequestMethod.POST, consumes= {"application/json"}, produces="application/json")
//	public User logOut(HttpSession sess, @RequestBody User use, User curr) {
//		User authUser = userService.validateUser(use);
//		if(authUser != null) {
//			sess.invalidate();
//		}
//		return curr;
//	}
	
	
}
