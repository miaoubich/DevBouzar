package com.miaoubich.demo;

public class Restaurant {
	
	IHotDrink hotdrink;
	
	Restaurant(IHotDrink hotdrink){
		this.hotdrink = hotdrink;
	}
	
	public void preparehotdrink(){
		hotdrink.prepareHotDrink();
	}
}
