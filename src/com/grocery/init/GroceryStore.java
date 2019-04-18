package com.grocery.init;

import java.util.ArrayList;
import java.util.List;

import com.grocery.item.LineItem;
import com.grocery.item.Product;

public class GroceryStore {
	private static GroceryStore store;
	private List<LineItem> products;
	
	private GroceryStore () {
		products = new ArrayList<LineItem>();
		init();
	}
	
	private void init() {
		products.add(new LineItem(new Product("lays", "supplier"), 10.0, 100));
		products.add(new LineItem(new Product("appy", "supplier"), 15.0, 100));
		products.add(new LineItem(new Product("medimix", "supplier"), 34.0, 150));
		products.add(new LineItem(new Product("amul", "supplier"), 24.0, 75));
	}
	
	public static GroceryStore getInstance() {
		if (store == null) {
			return new GroceryStore();
		}
		return store;
	}
	
	public Double getPrice(Product product) {
		Double price = 0d;
		for(LineItem productItem: products) {
			if (productItem.getProduct().equals(product)) {
				price = productItem.getPrice();
			}
		}
		
		return price;
	}
	
	public void debit(LineItem item) {
		for(LineItem productItem: products) {
			if (productItem.getProduct().equals(item.getProduct())) {
				productItem.reduceQuantity(item.getQuantity());
			}
		}
	}
}
