package com.example.androidpos;

public class ItemDescription {

	private String name;
	private String ID;
	private int quantity;
	private String description;
	private String unit;
	private double price;
	private double cost;
	
	public ItemDescription(String name, String ID, int quantity,
			String description, String unit, double price, double cost) {
		this.name = name;
		this.ID = ID;
		this.quantity = quantity;
		this.description = description;
		this.unit = unit;
		this.price = price;
		this.cost = cost;
	}

	public String getDiscription() {
		return description;
	}
}
