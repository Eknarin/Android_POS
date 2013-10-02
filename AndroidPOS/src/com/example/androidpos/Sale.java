package com.example.androidpos;

import java.util.ArrayList;

public class Sale {

	private static Sale instance = null;
	//private SaleLineItem SLI;
	private ArrayList<SaleLineItem> SLI;
	private Sale() {
	}

	public static Sale getInstance() {
		if (instance == null) {
			instance = new Sale();
		}
		return instance;
	}

	public boolean createSaleLineItem() {
		if (SLI == null) {
			SLI = new ArrayList<SaleLineItem>();
			return true;
		}
		return false;
	}

	public boolean editSaleLineItem(ItemDescription item) {
		return true;
	}

	public boolean removeSaleLineItem() {
		if (SLI != null) {
			SLI = null;
			return true;
		}
		return false;
	}

	public boolean calculate() {
		return true;
	}
}
