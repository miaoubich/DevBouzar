package com.miaoubich.demo;

public class Tea implements IHotDrink {

	@Override
	public void prepareHotDrink() {
		System.out.println("Dear Customer we are preparing Tea For YOU Using setter method!");
	}

}
