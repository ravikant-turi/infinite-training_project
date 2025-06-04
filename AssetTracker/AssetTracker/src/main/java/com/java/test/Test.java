package com.java.test;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.java.util.HibernateUtil;

public class Test {
	
	public static void main(String[] args) {
		
		SessionFactory sesionFactory=HibernateUtil.getSessionFactory();
		
		Session session=sesionFactory.openSession();
		
		Transaction  trans=session.beginTransaction();
		
		System.out.println("session" + session);
		
		session.close();
		
		trans.commit();
		
		
	}

}
