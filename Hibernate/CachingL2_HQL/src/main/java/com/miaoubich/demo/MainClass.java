package com.miaoubich.demo;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainClass {

	public static void main(String[] args) {

		Student s = null;
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(sr);

		Session session1 = factory.openSession();
		Transaction tr1 = session1.beginTransaction();
		
		Query q1 = session1.createQuery("from Student where sid=102");
		q1.setCacheable(true);
		s = (Student) q1.uniqueResult();
		System.out.println(s);
		
		tr1.commit();
		session1.close();
		
		Session session2 = factory.openSession();
		Transaction tr2 = session2.beginTransaction();
		
		Query q2 = session2.createQuery("from Student where sid=102");
		q2.setCacheable(true);
		s = (Student) q2.uniqueResult();
		System.out.println(s);
		
		tr2.commit();
		session2.close();
	}

}
