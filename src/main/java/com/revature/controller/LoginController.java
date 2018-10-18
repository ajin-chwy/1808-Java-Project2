package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.revature.pojos.User;
import com.revature.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@SessionAttributes("authUser")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET, produces="application/json")
	public List<User> loginGetAll(HttpSession sess) {
		System.out.println("In loginGetAll");
		List<User> uList = userService.getAllUsers();
		return uList;
	}
	
	@RequestMapping(value="/login/{id}", method=RequestMethod.GET)
	public User loginGet (HttpSession sess, @PathVariable(value="id") Integer id) {
		System.out.println("In loginGet");
		System.out.println(id);
		System.out.println(userService.getUser(id).getSavedRecipes());
		return userService.getUser(id);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, produces="application/json", consumes= {"application/json"})
	public User loginPost(@RequestBody User user, HttpSession sess) {
		System.out.println("In loginPost");
		System.out.println(user);
		User authUser = userService.validateUser(user);
		if(authUser != null) {
			sess.setAttribute("user", authUser);
			System.out.println("current sess holder is " + sess.getAttribute("user"));
		}
		return authUser;
	}
}
