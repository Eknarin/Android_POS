package com.example.androidpos;

public class SaleController {
	private static SaleController instance = null;
	private Sale sale;
	
	private SaleController(){}
	
	public static SaleController getInstance(){
		if(instance == null){
			instance = new SaleController();
		}
		return instance;
	}
	
	public boolean createSale(){
		sale = Sale.getInstance();
		if(sale!=null){
			return true;
		}
		return false;
	}
	
	public boolean addSaleLineItem(ItemDescription item){
		if(sale.editSaleLineItem(item)){
			return true;
		}
		return false;
	}
	
	public boolean removeSaleLineItem(ItemDescription item){
		if(sale.editSaleLineItem(item)){
			return true;
		}
		return false;
	}
	
	public boolean finishTransacTion(){
		return sale.calculate();
	}
	
	public boolean updateSaleLedger(){
		return false;
		
	}
	
	public boolean updateInventory(){
		return false;
		
	}
}
