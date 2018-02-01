package com.miaoubich.demo;

import java.util.Iterator;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainClass {

	public static void main(String[] args) {

		Users user = new Users();
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Users.class);
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(sr);
		Session session = factory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		List list = session.createQuery("from Users u").list();
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			Object obj = (Object)it.next();
			Users u = (Users)obj;
			
			System.out.println("ID: " + u.getUid());
			System.out.println("Firstname: " + u.getUfname());
			System.out.println("Lastname: " + u.getUlname());
		}
		tr.commit();
		
		session.close();
		factory.close();

	}

}
