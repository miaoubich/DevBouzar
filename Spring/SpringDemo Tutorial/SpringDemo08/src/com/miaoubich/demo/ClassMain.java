//13- Bean Life Cycle using Annotations and InitializingBean,DisposableBean interface

package com.miaoubich.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("NewFile.xml");
		((AbstractApplicationContext) context).registerShutdownHook(); //to destroy all the beans after the program finish
		
		Restaurant rObj = (Restaurant) context.getBean("restoBean");
		rObj.greetCustomer();
		
		((AbstractApplicationContext) context).close();

	}

}
