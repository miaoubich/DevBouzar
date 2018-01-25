package com.miaoubich.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClassMain {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		Restaurant Robj02 = (Restaurant) context.getBean("restoBean02");
		Robj02.greetCustomer();
		
		((AbstractApplicationContext) context).close();

	}

}
