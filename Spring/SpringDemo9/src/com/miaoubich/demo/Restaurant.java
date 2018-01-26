package com.miaoubich.demo;

public class Restaurant {

	public void greetCustomer(){
		System.out.println("Welcome Customer !");
	}
	
	public void init(){
		System.out.println("Bean is initializing");
	}
	
	public void destroy(){
		System.out.println("Bean Is destroying now");
	}
}
