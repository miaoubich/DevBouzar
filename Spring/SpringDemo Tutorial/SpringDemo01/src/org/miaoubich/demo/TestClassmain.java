package org.miaoubich.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClassmain {

		public static void main(String[] args){
			
			ApplicationContext con = new ClassPathXmlApplicationContext("CinfigSpring.xml");
			
			Restaurant Robj1= (Restaurant) con.getBean("restoBean");
			
			Robj1.greetCustomer();
			
			((AbstractApplicationContext) con).close();
		}
}
