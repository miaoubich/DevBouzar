package com.miaoubich.demo;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainClass {

	public static void main(String[] args) {
				
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(registry);
		Session session = sf.openSession();
		
		Transaction tr = session.beginTransaction();
		
		List list = session.createQuery("FROM Laptop").list();
		Iterator itr = list.iterator();
		
		while(itr.hasNext()) {
			Object obj =(Object)itr.next();
			Laptop lap = (Laptop)obj;
			
			System.out.println("Brand: "+ lap.getLname());
			System.out.println("Student: "+ lap.getStudent());
			System.out.println("-------------------------");
			
//			Collection<Laptop> laps = s.getLaptop();
//			
//			for(Laptop l :laps) {
//				Object obj1 = (Object)l;
//				Laptop l1 = (Laptop)obj1;
//				System.out.println(l1.getLname());
//			}
		}
		
		tr.commit();
	}

}
