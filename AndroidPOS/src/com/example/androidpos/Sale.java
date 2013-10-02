package com.example.androidpos;

public class Sale {

	private static Sale instance = null;
	private SaleLineItem SLI;
	private Sale(){}
	
	public static Sale getInstance(){
		if(instance == null){
			instance = new Sale();
		}
		return instance;
	}
	
	private boolean createSaleLineItem(){
		SLI = new SaleLineItem();
		return true;
	}
}
