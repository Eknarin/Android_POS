package com.example.androidpos;

public class ItemDescription {

	private String name;
	private int quantity;
	private String description;
	private String unit;
	private double price;
	private double cost;
	
	public ItemDescription(String name, int quantity, String description, String unit, double price, double cost) {
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.unit = unit;
		this.price = price;
		this.cost = cost;
	}

	public void updateQuantity( int quantity ) {
		this.quantity += quantity;
	}
	
	public String [] getDescription() {
		String [] data = new String[6];
		data[0] = this.name;
		data[1] = ""+this.quantity;
		data[2] = this.description;
		data[3] = this.unit;
		data[4] = ""+this.price;
		data[5] = ""+this.cost;
		return data;
	}
	
	public boolean update(ItemDescription item) {
		this.description = item.description;
		this.unit = item.unit;
		this.price = item.price;
		this.cost = item.cost;
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj == null ) return false;
		
		if ( this.getClass() != obj.getClass() ) return false;
		
		ItemDescription item = (ItemDescription)obj;
		
		return this.name == item.name;
	}

}
