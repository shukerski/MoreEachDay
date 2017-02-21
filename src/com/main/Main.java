package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.user.UserManager;

public class Main {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			factory = new Configuration().configure("com/resources/hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Session session = factory.openSession();
		UserManager userManager = new UserManager(session);

		/* Add few employee records in database */
		Integer userID1 = userManager.addUser("b0r1s", "borcho@abv.bg", "pass");
		Integer userID2 = userManager.addUser("mitaka", "mitaka@abv.bg", "pass2");


		session.close();

	}

}
