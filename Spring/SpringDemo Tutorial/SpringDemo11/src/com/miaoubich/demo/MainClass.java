// 16. A BeanFactoryPostProcessor concept in spring

package com.miaoubich.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		((AbstractApplicationContext) context).registerShutdownHook();//to destroy all the beans after the program finish
		
		Restaurant Robj1 = (Restaurant) context.getBean("restoBean");
		Robj1.greetCustomer();
		
		((AbstractApplicationContext) context).close();
	}

}
