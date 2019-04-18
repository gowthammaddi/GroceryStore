package com.grocery.billing;

import java.util.List;

import com.grocery.customer.Customer;
import com.grocery.init.GroceryStore;
import com.grocery.item.LineItem;
import com.grocery.pricing.Pricing;

public class Register {
	public Double saleValueForTheDay = 0.0;
	public GroceryStore store = GroceryStore.getInstance();
	
	private Double totalCartValue(List<LineItem> items) {
		Double cartValue = 0.0;
		for (LineItem item: items) {
			cartValue += item.totalItemPrice();
		}
		
		return cartValue;
	}
	
	public String confirmOrder(Customer customer, Order order) {
		List<LineItem> items = order.getItems();
		saleValueForTheDay += totalCartValue(items);		
		for(LineItem item: items) {
			item = Pricing.discountedItem(customer, item);
		}
		debitFromStore(items);
		String bill = generateBill(customer, items);
		
		return bill;
	}
	
	private void debitFromStore(List<LineItem> items) {
		for(LineItem item: items) {
			store.debit(item);
		}
	}
	
	private String generateBill(Customer customer, List<LineItem> items) {
		StringBuilder bill = new StringBuilder();
		for(LineItem item: items) {
			bill.append(item).append("\n");
		}
		bill.append("Total Cart Value purchased by " + customer.getName() + ": " + totalCartValue(items));
		
		return bill.toString();
	}
}
