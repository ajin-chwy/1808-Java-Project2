package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.pojos.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao = new UserDAOImpl();
	
	@Override
	public User validateUser(User user) {
		if(user == null) {
			return null;
		}
		User authUser = userDao.getUser(user.getUserId());
		return authUser;
	}

	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

}
