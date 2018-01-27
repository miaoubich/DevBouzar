package com.miaoubich.demo;

import java.util.List;

public class Restaurant {
	
	private List listOdWaiters;
	
	
	public void setListOdWaiters(List listOdWaiters) {
		this.listOdWaiters = listOdWaiters;
	}


	public void displayWaitersNames(){
		System.out.println("All waiters workers in the restaurant: " + listOdWaiters);
	}
}
