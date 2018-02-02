package com.miaoubich.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainClass {

	public static void main(String[] args) {
		
		Laptop laptop = new Laptop();
		Student s = new Student();
		
		laptop.setLname("LENOVO");
		//laptop.setStudent(s); //when we use OntToMany
		laptop.getStudent().add(s);//ManyToMany

		
		s.setName("ALI");
		s.setMarks(5);
		//s.setLaptop(laptop); //when we use OneToOne relation
		s.getLaptop().add(laptop);// OneToMany relation
		
				
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(registry);
		Session session = sf.openSession();
		
		Transaction tr = session.beginTransaction();
		
		session.save(laptop);
		session.save(s);
		
		tr.commit();

	}

}
