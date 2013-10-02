package com.example.androidpos;

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
	
	public void searchItem() {

	}

	public String[] getItemDescription() {
		return null;

	}
}
