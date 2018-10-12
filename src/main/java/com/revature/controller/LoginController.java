package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojos.User;
import com.revature.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public List<User> loginGetAll(HttpSession sess) {
		System.out.println("In here");
		List<User> uList = userService.getAllUsers();
		System.out.println(uList);
		return uList;
	}
	
	@RequestMapping(value="/login/{id}", method=RequestMethod.GET)
	public User loginGet (HttpSession sess, int id) {
		System.out.println("In there");
		return userService.getUser(id);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, produces="application/json")
	public User loginPost(@RequestBody User use, HttpSession sess) {
		return userService.validateUser(use);
	}
}
