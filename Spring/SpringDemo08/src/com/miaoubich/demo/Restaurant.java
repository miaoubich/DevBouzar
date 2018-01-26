//package com.miaoubich.demo;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//
//public class Restaurant {
//
//	public void greetCustomer(){
//		System.out.println("Welcome back Sir !");
//	}
//	
//	@PostConstruct
//	 public void init(){
//		  System.out.println("Restaurant Bean is going through init");
//	}
//	
//	@PreDestroy
//	public void destroy(){
//		System.out.println("Bean will destroy now");
//	}
//}

//the following is another method usibg init and destroy method
package com.miaoubich.demo;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Restaurant implements InitializingBean, DisposableBean{

	public void greetCustomer(){
		System.out.println("Welcome back Sir !");
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("Restaurant Bean is going through afterPropertiesSet");
		
	}

	@Override
	public void destroy() throws Exception {


		System.out.println("Restaurant Bean is destroying now.");
		
	}
	
}
