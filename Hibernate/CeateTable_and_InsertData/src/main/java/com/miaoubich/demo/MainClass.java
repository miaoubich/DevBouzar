package com.miaoubich.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainClass {

	public static void main(String[] args) {

		Users user = new Users();
		
		//user.setUid(1);
		user.setUfname("A");
		user.setUlname("AA");
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Users.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(user);
		
		tx.commit();
	}

}
