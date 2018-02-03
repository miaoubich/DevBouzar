package com.miaoubich.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainClass {

	public static void main(String[] args) {
		
		Student s = null;

		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(StudentName.class);
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(sr);
		
		Session session1 = factory.openSession();
		Transaction tr1 = session1.beginTransaction();
		s = (Student) session1.get(Student.class, 102);
		System.out.println(s);
		tr1.commit();
		session1.close();
		
		Session session2 = factory.openSession();
		Transaction tr2 = session2.beginTransaction();
		s = (Student) session2.get(Student.class, 102);
		System.out.println(s);
		tr2.commit();
		session2.close();
	}
}
