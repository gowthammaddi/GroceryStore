package com.grocery.init;

import java.util.ArrayList;
import java.util.List;

import com.grocery.discount.ItemDiscountCalculator;
import com.grocery.model.Item;
import com.grocery.model.LineItem;

public class Inventory {
	private static Inventory store;
	private List<LineItem> itemList;
	
	private Inventory () {
		itemList = new ArrayList<LineItem>();
		init();
	}
	
	private void init() {
		itemList.add(new LineItem(new Item("lays", 10.0), 100));
		itemList.add(new LineItem(new Item("appy", 15.0), 100));
		itemList.add(new LineItem(new Item("medimix", 34.0), 150));
		itemList.add(new LineItem(new Item("amul", 24.0), 75));
	}
	
	public static Inventory getInstance() {
		if (store == null) {
			return new Inventory();
		}
		return store;
	}
	
	public Double getPrice(Item requiredItem) {
		Double price = 0d;
		for(LineItem item: itemList) {
			if (item.getItem().equals(requiredItem)) {
				price = item.getPrice();
			}
		}
		
		return price;
	}
	
	public void debit(LineItem debitItem) {
		for(LineItem item: itemList) {
			if (item.getItem().equals(debitItem.getItem())) {
				item.reduceQuantity(debitItem.getQuantity());
			}
		}
	}
}
