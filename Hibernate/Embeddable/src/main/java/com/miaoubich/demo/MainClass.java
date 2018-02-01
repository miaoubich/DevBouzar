package com.miaoubich.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainClass {

	public static void main(String[] args) {

		FullName fn = new FullName();
		fn.setName("Aben");
		fn.setMiddleName("Santos");
		fn.setSecondName("Medo");
		
		Users user = new Users();
		user.setUfname(fn);
		user.setUlname("Timbre");
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Users.class);
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(sr);
		Session session = factory.openSession();
		
		Transaction tr = session.beginTransaction();
		session.save(user);
		
		System.out.println("\nData saved Successfully!");
		tr.commit();
		session.close();
		factory.close();

	}

}
