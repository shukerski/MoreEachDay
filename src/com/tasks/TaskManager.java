package com.tasks;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TaskManager {

		private Session session;

		public TaskManager(Session session) {
			this.session = session;
		}

		public Integer addTask(int categoryID, int level, String description) {
			Transaction t = null;
			Integer taskID = null;
			
			try {
				t = session.beginTransaction();
				Task newTask = new Task(categoryID, level, description);
				taskID = (Integer) session.save(newTask);
				t.commit();
			} catch (HibernateException e) {
				if (t != null)
					t.rollback();
				e.printStackTrace();
			}
			return taskID;
		}

}

