package com.user;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SocialGraphManager {
	private Session session;

	public SocialGraphManager(Session session) {
		// TODO Auto-generated constructor stub
		this.session = session;
	}

	public void follow(int followerID, int followeeID) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			SocialLink socialLink = new SocialLink(followerID, followeeID);
			session.save(socialLink);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

/*	public void unfollow(int followerID, int followeeID) {
		Transaction tx = null;
		try {
			  String hql = "delete from social_graph where follower_id = :followerID AND followee_id = :followeeID";
			  Query query = session.createQuery(hql);
			  query.setInteger("followerID", followerID);
			  query.setInteger("followeeID", followeeID);
			  query.executeUpdate();
			  tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		}
	}*/

}
