package com.user;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserManager {
	private Session session;

	public UserManager(Session session) {
		// TODO Auto-generated constructor stub
		this.session = session;
	}

	public Integer addUser(String username, String email, String password) {
		Transaction tx = null;
		Integer userID = null;
		
		try {
			tx = session.beginTransaction();
			User newUser = new User(username, email, password);
			userID = (Integer) session.save(newUser);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return userID;
	}
}
