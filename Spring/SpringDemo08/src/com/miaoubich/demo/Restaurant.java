package com.miaoubich.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Restaurant {

	public void greetCustomer(){
		System.out.println("Welcome back Sir !");
	}
	
	@PostConstruct
	 public void init(){
		  System.out.println("Restaurant Bean is going through init");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Bean will destroy now");
	}
}
