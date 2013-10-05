package com.example.androidpos;

public class ItemDescription {

	private String _id;
	private String name;
	private int quantity;
	
	/*
	private String description;
	private String unit;
	private double price;
	private double cost;
	*/
	
	public ItemDescription(String _id , String name, int quantity/**,
			String description, String unit, double price, double cost*/) {
		this._id = _id;
		this.name = name;
		this.quantity = quantity;
		/*this.description = description;
		this.unit = unit;
		this.price = price;
		this.cost = cost;*/
	}

	public void updateQuantity( int quantity ) {
		this.quantity += quantity;
	}
	
	public String [] getDescription() {
		String [] data = new String[3];
		data[0] = this._id;
		data[1] = this.name;
		data[2] = ""+this.quantity;
		return data;
	}
	

	@Override
	public boolean equals(Object obj) {
		if ( obj == null ) return false;
		
		if ( this.getClass() != obj.getClass() ) return false;
		
		ItemDescription item = (ItemDescription)obj;
		
		return this.name == item.name;
	}
}
