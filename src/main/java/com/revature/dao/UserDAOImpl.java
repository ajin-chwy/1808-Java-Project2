package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.revature.pojos.User;
import com.revature.util.SessionUtil;

@Service
public class UserDAOImpl implements UserDAO{

	private static Session curr = SessionUtil.getSession();
	
	public User getUser(int id) {
		User use = curr.get(User.class, id);
		return use;
	}

	public List<User> getAllUser() {
		List<User> uList = new ArrayList<User>();
		uList = curr.createCriteria(User.class).list();
		return uList;
	}

	public void deleteUser(User use) {
		curr.beginTransaction();
		curr.delete(use);
		curr.getTransaction().commit();
	}

	public void createUser(User use) {
		if(use == null) {
			System.out.println("use is null");
		} else {
			System.out.println("use is not null");
		}
		curr.beginTransaction();
		curr.saveOrUpdate(use);
		curr.getTransaction().commit();
		System.out.println("user insert?");
	}

	public void updateUser(User use) {
		curr.beginTransaction();
		curr.merge(use);
		curr.getTransaction().commit();
	}

}
