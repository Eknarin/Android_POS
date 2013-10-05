package com.example.androidpos;

import java.util.ArrayList;
import java.util.List;

public class Sale {

	private List<SaleLineItem> list;
	
	public Sale() {
		this.list = new ArrayList<SaleLineItem>();
	}

	public boolean createSaleLineItem() {
		return false;
	}

	public boolean editSaleLineItem(ItemDescription item) {
		return true;
	}

	public boolean removeSaleLineItem() {
		return false;
	}

	public boolean calculate() {
		return true;
	}
}
