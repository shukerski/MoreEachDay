package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tasks.TaskManager;
import com.user.SocialGraphManager;
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

//		SocialGraphManager socialGraphManager = new SocialGraphManager(session);
//		socialGraphManager.follow(14, 17);
/*		socialGraphManager.unfollow(19, 20);*/
		
		TaskManager tm = new TaskManager(session);
		tm.addTask(1, 1, "Go out and have fun!");

//		System.out.println(userID2);
		session.close();

	}

}
