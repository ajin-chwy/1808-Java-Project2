package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.revature.pojos.User;
import com.revature.util.SessionUtil;

@Service
public class UserDAOImpl implements UserDAO{

	private Session curr;
	
	public User getUser(int id) {
		curr = SessionUtil.getSession();
		return curr.get(User.class, id);
	}

	public List<User> getAllUser() {
		List<User> uList = new ArrayList<User>();
		curr = SessionUtil.getSession();
		uList = curr.createCriteria(User.class).list();
		return uList;
	}

	public void deleteUser(User use) {
		SessionUtil.getSession().delete(use);
	}

	public void createUser(User use) {
		if(use == null) {
			System.out.println("use is null");
		} else {
			System.out.println("use is not null");
		}
		curr = SessionUtil.getSession();
		curr.beginTransaction();
		curr.saveOrUpdate(use);
		curr.getTransaction().commit();
		System.out.println("user insert?");
	}

	public void updateUser(User use) {
		SessionUtil.getSession().merge(use);
	}

}
