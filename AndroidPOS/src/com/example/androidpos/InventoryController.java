package com.example.androidpos;

import java.util.List;

public class InventoryController {
	
	private Inventory inventory;

	public InventoryController(Inventory inventory) {
		this.inventory = inventory;
	}

	public boolean addItem(String _id, String name, int quantity , String description , String unit , double price , double cost) {
		return inventory.create(_id, name, quantity, description, unit, price, cost);
	}

	public boolean editItem( String name, String unit , double price , double cost) {
		return inventory.edit(name, unit, price, cost);
	}

	public boolean removeItem( String _id ) {
		return inventory.remove(_id);
	}

	public String [] getItem( String _id ) {
		return inventory.select(_id);
	}
	
	public String [][] getItemDescription() {
		List<ItemDescription> list = inventory.getItemDescriptionList();
		String [][] data = new String[ list.size() ][3];
		for ( int i = 0 ; i < list.size() ; i++ )
			data[i] = list.get(i).getDescription();
		return data;
	}
	
	public void searchItem() {

	}

}
