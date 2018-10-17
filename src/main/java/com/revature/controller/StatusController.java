package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.revature.pojos.User;
import com.revature.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@SessionAttributes("user")
public class StatusController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/status", method=RequestMethod.GET, produces="application/json")
	public User checkStatus(HttpSession sess, User use) {
		User authUser = use;
		try {
			authUser = (User) sess.getAttribute("user");
			System.out.println("current session? " + sess.getAttribute("user"));
		} catch (Exception e) {
			System.out.println("no session created");
		}
		return authUser;
	}
	
	@RequestMapping(value="/status", method=RequestMethod.POST, consumes= {"application/json"}, produces="application/json")
	public User logOut(HttpSession sess, @RequestBody User use, User curr) {
		User authUser = userService.validateUser(use);
		if(authUser != null) {
			sess.invalidate();
		}
		return curr;
	}
}
