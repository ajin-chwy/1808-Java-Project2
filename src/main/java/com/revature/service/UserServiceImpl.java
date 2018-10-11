package com.revature.service;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.pojos.User;

public class UserServiceImpl implements UserService{

	private UserDAO userDao = new UserDAOImpl();
	@Override
	public User validateUser(User user) {
		User authUser = userDao.getUser(user.getUserId());
		return authUser;
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
