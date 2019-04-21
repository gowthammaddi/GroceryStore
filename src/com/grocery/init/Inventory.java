package com.grocery.init;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.grocery.model.Item;
import com.grocery.model.LineItem;

public class Inventory {
	private static Inventory store;
	private List<LineItem> itemList;
	private final String NEWLINE = "\n";
	
	private Inventory () {
		itemList = new ArrayList<LineItem>();
		init();
	}
	
	private void init() {
		Properties property = new Properties();
		try {
			property.load(new FileInputStream("./resources/inventory.properties"));
			
			String[] productNames = property.getProperty("productName").split(",");
			String[] productPrices = property.getProperty("productPrice").split(",");
			String[] productQuantities = property.getProperty("productQuantity").split(",");

			for (int i=0; i<productNames.length; i++) {
				String productName = productNames[i];
				Double productPrice = Double.parseDouble(productPrices[i]);
				Integer productQuantity = Integer.parseInt(productQuantities[i]);
				
				itemList.add(new LineItem(new Item(productName, productPrice), productQuantity));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Inventory getInstance() {
		if (store == null) {
			store = new Inventory();
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
	
	public String printInventory() {
		StringBuilder inventoryString = new StringBuilder();
		inventoryString.append("Inventory Details: ").append(NEWLINE);
		
		for(LineItem item: itemList) {
			inventoryString.append(item.getItem().getName()).append(" ")
						   .append(item.getQuantity())
						   .append(NEWLINE);
		}
		
		return inventoryString.toString();
	}
}
