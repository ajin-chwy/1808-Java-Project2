package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.pojos.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao;
	
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

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUser();
	}

	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}

}
