package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojos.User;
import com.revature.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGet(HttpSession sess) {
		if(sess.getAttribute("user") != null) {
			// TODO 
		}
		else {
			// TODO
		}
		return null;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, produces="application/json")
	public String loginPost(@RequestBody User use, HttpSession sess) {
		User authUser = userService.validateUser(use);
		
		if(authUser != null) {
			sess.setAttribute("user", authUser);
			//TODO implement when user is correctly logged in
			
		}
		//TODO implement when user is not correctly logged in	
		return null;
	}
}
