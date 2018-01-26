package com.miaoubich.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassMain {

	public static void main(String[] args) {
		
		ApplicationContext con = new ClassPathXmlApplicationContext("Spring.xml");
		
		Restaurant Robj1= (Restaurant) con.getBean("restoBean");
		Robj1.setWelcomeNote("WelcomeNote is coming from Object 1 !");
		Robj1.greetCustomer();
		
		Restaurant Robj2= (Restaurant) con.getBean("restoBean");
		Robj2.greetCustomer();
		
		((AbstractApplicationContext) con).close();

	}

}
