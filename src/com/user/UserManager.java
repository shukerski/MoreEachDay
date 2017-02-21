package com.user;

import org.hibernate.Session;

public class UserManager {
	private Session session;

	public UserManager(Session session) {
		// TODO Auto-generated constructor stub
		this.session = session;
	}

	public Integer addUser(String username, String email, String password) {
		// TODO Auto-generated method stub
		Integer userID = null;

		User newUser = new User(username, email, password);
		userID = (Integer) session.save(newUser);

		return userID;
	}
}
