package com.miaoubich.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainClass {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		Restaurant Robj05 = (Restaurant) context.getBean("restoBean05");
		Robj05.displayWaitersNames();
		
		((AbstractApplicationContext) context).close();
		
	}

}
