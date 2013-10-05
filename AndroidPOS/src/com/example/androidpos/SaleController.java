package com.example.androidpos;

public class SaleController {
	
	private Inventory inventory;
	private SaleLedger sl;
	
	
	public SaleController(Inventory inventory){
		this.inventory = inventory;
	}
	
	public boolean createSale(){
		return false;
	}
	
	public boolean addSaleLineItem(ItemDescription item){
		return false;
	}
	
	public boolean removeSaleLineItem(ItemDescription item){
		return false;
	}
	
	public boolean finishTransacTion(){
		return false;
	}
	
	public boolean updateSaleLedger(){
		return false;
		
	}
	
	public boolean updateInventory(){
		return false;
		
	}
}
