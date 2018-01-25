package com.miaoubich.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainClass {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		Restaurant Robj03 = (Restaurant) context.getBean("restoBean03");
		Robj03.preparehotdrink();
		
		((AbstractApplicationContext) context).close();

		
	}
}
