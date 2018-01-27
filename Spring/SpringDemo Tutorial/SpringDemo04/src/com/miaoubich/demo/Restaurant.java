package com.miaoubich.demo;

public class Restaurant {

	IHotDrink hotdrink;
	
	public void setHotdrink(IHotDrink hotdrink){
		this.hotdrink = hotdrink;
	}
	
	public void preparehotdrink(){
		hotdrink.prepareHotDrink();
	}
}
