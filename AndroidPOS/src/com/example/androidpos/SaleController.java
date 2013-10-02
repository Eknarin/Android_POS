package com.example.androidpos;

public class SaleController {
	private static SaleController instance = null;
	private Sale sale;
	private InventoryController IC = new InventoryController();
	
	private SaleController(){}
	
	public static SaleController getInstance(){
		if(instance == null){
			instance = new SaleController();
		}
		return instance;
	}
	
	private boolean createSale(){
		sale = Sale.getInstance();
		if(sale!=null){
			return true;
		}
		return false;
	}
	
	private boolean addSaleLineItem(ItemDescription item){
		if(sale.editSaleLineitem(item)){
			return true;
		}
		return false;
	}
	
	private boolean removeSaleLineItem(ItemDescription item){
		if(sale.editSaleLineitem(item)){
			return true;
		}
		return false;
	}
	
	private boolean finishTransacTion(){
		sale.calculate();
	}
	
	private boolean updateSaleLedger(){
		
	}
	
	private boolean updateInventory(){
		
	}
}
