package com.example.androidpos;
//By zee
public class ItemDescription {
	public ItemDescription(String name, int ID, int quantity,
			String description, String unit, double price, double cost) {
		this.name = name;
		this.ID = ID;
		this.quantity = quantity;
		this.description = description;
		this.unit = unit;
		this.price = price;
		this.cost = cost;
	}

	private String name;
	private int ID;
	private int quantity;
	private String description;
	private String unit;
	private double price;
	private double cost;

	public String getDiscription() {
		return description;
	}
}