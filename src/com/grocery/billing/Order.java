package com.grocery.billing;

import java.util.ArrayList;
import java.util.List;

import com.grocery.item.LineItem;

public class Order {
	private List<LineItem> items;
	
	public Order() {
		items = new ArrayList<LineItem>();
	}
	
	public void addItem(LineItem item) {
		items.add(item);
	}
	
	public List<LineItem> getItems() {
		return items;
	}	
}
