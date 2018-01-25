package com.miaoubich.demo;

public class Restaurant {
	
	private String welcomeNote;
	
	public void setWelcomeNote(String welcomenote){
		this.welcomeNote = welcomenote;
	}
	
	public void greetCustomer(){
		System.out.println(welcomeNote);
	}
}
