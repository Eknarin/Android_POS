package com.example.androidpos;

import java.util.List;

public class InventoryController {
	
	private Inventory inventory;

	public InventoryController(Inventory inventory) {
		this.inventory = inventory;
	}

	public boolean addItem(String _id, String name) {
		return inventory.create(_id, name);
	}

	public boolean editItem( String _id , String name ) {
		return inventory.edit(_id, name);
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
