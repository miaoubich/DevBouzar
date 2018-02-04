package com.miaoubich.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainClass {

	public static void main(String[] args) {
		
		try {
			Configuration config = new Configuration().configure().addAnnotatedClass(Person.class);
			ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			SessionFactory factory = config.buildSessionFactory(sr);
			Session session = factory.openSession();
			Transaction tr = session.beginTransaction();
			
			//insert 50 random name
			/*
			Random r = new Random();
			
			for(int i=1; i<=50; i++) {
				
				Person p = new Person();
				
				p.setId(i);
				p.setName("Name"+i);
				p.setMark(r.nextInt(100));
				
				session.save(p);
			}
			*/
			
			//print out multiple data without using toString() method
			/*
			List<Person> persons = session.createQuery("from Person where mark > 50").list();
			Iterator it = persons.iterator();
			
			int j=0;
			
			while(it.hasNext()) {
				Object obj =(Object)it.next();
				Person p = (Person)obj;
				j++;
				System.out.println("\nID: " + p.getId());
				System.out.println("Name: " + p.getName());
				System.out.println("Mark: " + p.getMark());
				System.out.println("\n-------------------------");
			}
			
			System.out.println("There are " + j +" person(s)");
			*/
			
			//or use:
			/*
			Query q = session.createQuery("select id,name,mark from Person");
			//Query q = session.createQuery("select id,name,mark from Person p where p.mark>50 and p.mark<55");
			List<Object[]> persons = (List<Object[]>) q.list();
			
			for(Object[] person: persons) {
			System.out.println("\nID: " + person[0] + "\nName: " + person[1] + "\nMark: " +person[2]);
			System.out.println("-------------------");
			}
			*/
			
			//print all using SQL query (Native queries) in hibernate
			/*
			SQLQuery query = session.createSQLQuery("select *from Person");
			query.addEntity(Person.class);
			List<Person> persons = query.list();
			Iterator it = persons.iterator();
			
			while(it.hasNext()) 
			{
				Object obj = (Object)it.next();
				Person p = (Person)obj;
				
				System.out.println("\nID: " + p.getId());
				System.out.println("Name: " + p.getName());
				System.out.println("Mark: " + p.getMark());
				System.out.println("\n-------------------------");
			}
			*/
			
			//print some columns using native queries(sql queries) in hibernate
			SQLQuery query = session.createSQLQuery("select name,mark from Person where mark>90");
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List persons = query.list();
			Iterator it = persons.iterator();
			
			while(it.hasNext()) 
			{
				Map m = (Map)it.next();
				System.out.println("Name: " + m.get("name") + "\nMark: " + m.get("mark"));
				System.out.println("-----------------------");
			}
			
			//To get the sum of Marks
			/*
			Query q = session.createQuery("select sum(mark) from Person");
			Object Sum1 = (Object) q.uniqueResult();//it return it as Object
			Long Sum2 = (Long) q.uniqueResult();//it return it also as Long
			
			System.out.println("SUM of Marks as Object: " + Sum1);
			System.out.println("SUM of Marks as Long: " + Sum2);
			*/
			
			//To get sum of marks with condition
			/*
			int a = 70;
			Query q = session.createQuery("select sum(mark) from Person p where p.mark > :a");
			q.setParameter("a", a);
			Long Sum = (Long) q.uniqueResult();
			
			System.out.println("SUM of Marks is: " + Sum);
			*/
			
			//print out one unique data
			/*
			//with HQL query
			Query q = session.createQuery("from Person where id=10");
			Person p = (Person) q.uniqueResult();
			
			System.out.println("\nID: " + p.getId());
			System.out.println("Name: " + p.getName());
			System.out.println("Mark: " + p.getMark());
			*/
			
			//with SQL query
			/*
			Query q = session.createQuery("select id,name,mark from Person where id=2");
			Object[] person = (Object[]) q.uniqueResult();
			
			//we can print it as:
			System.out.println("\nID: " + person[0] + "\nName: " + person[1] + "\nMark: " +person[2]);
			System.out.println("-------------------");
			//or as:
			for(Object O: person) {
				System.out.println(O);
			}
			*/
			
			tr.commit();
		
		}catch(Exception ex) 
		{
			System.out.println(ex);
		}

	}

}
