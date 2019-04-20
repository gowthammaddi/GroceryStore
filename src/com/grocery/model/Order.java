package com.grocery.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<LineItem> itemList;
	private Integer id;
	private Customer customer;
	private boolean isEmployeeOrder;
	private Double totalOrderValue;
	private static final String NEWLINE = "\n";
	
	public Order(Customer customer, boolean isEmployee, Integer id) {
		itemList = new ArrayList<LineItem>();
		this.customer = customer;
		this.isEmployeeOrder = isEmployee;
		this.id = id;
		totalOrderValue = 0d;
	}
	
	public void addItem(LineItem item) {
		itemList.add(item);
		totalOrderValue += item.getPrice();
	}
	
	public List<LineItem> getItems() {
		return itemList;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public boolean isEmployeeOrder() {
		return isEmployeeOrder;
	}
	
	public void setTotalOrderValue(Double totalOrderValue) {
		this.totalOrderValue = totalOrderValue;
	}
	
	public Double getTotalOrderValue() {
		return totalOrderValue;
	}
	
	@Override
	public String toString() {
		StringBuilder bill = new StringBuilder();
		
		bill.append("Billing ID: ")
			.append(id).append(NEWLINE);
		
		bill.append("Customer Name: ") 
			.append(customer.getName()).append(NEWLINE);
		
		if(isEmployeeOrder) {
			bill.append("Employee: ")
				.append(isEmployeeOrder).append(NEWLINE);
		}
		
		for(LineItem item: itemList) {
			bill.append(item).append(NEWLINE);
		}
		
		bill.append("Total Order value: ")
			.append(totalOrderValue).append(NEWLINE);
		
		return bill.toString();
	}
}
