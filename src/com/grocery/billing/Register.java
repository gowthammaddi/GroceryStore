package com.grocery.billing;

import java.util.ArrayList;
import java.util.List;

import com.grocery.init.Inventory;
import com.grocery.model.Order;
import com.grocery.model.Customer;
import com.grocery.model.LineItem;
import com.grocery.discount.*;

public class Register {
	public Double saleValueForTheDay;
	public Inventory store = Inventory.getInstance();
	public List<ItemDiscountCalculator> itemDiscountCalculatorList;
	public List<OrderDiscountCalculator> orderDiscountCalculatorList;
	
	private Integer id = 1;
	
	public Register() {
		saleValueForTheDay = 0d;
		itemDiscountCalculatorList = new ArrayList<ItemDiscountCalculator>();
		orderDiscountCalculatorList = new ArrayList<OrderDiscountCalculator>();
		
		orderDiscountCalculatorList.add(new EmployeeOrderDiscountCalculator());
		orderDiscountCalculatorList.add(new SeniorCitizenOrderDiscountCalculator());
		
		itemDiscountCalculatorList.add(new ItemCategoryDiscountCalculator());
	}
	
	public Order createOrder(List<LineItem> itemList, Customer customer, boolean isEmployee) {
		Order order = new Order(customer, isEmployee, id++);
		for(LineItem item: itemList) {
			for(ItemDiscountCalculator itemDiscountCalculator: itemDiscountCalculatorList) {
				item = itemDiscountCalculator.applyDiscount(item);
			}
			order.addItem(item);
		}
		
		for(OrderDiscountCalculator orderDiscountCalculator: orderDiscountCalculatorList) {
			orderDiscountCalculator.applyDiscount(order);
		}
		
		return order;
	}
	
	public String confirmOrder(Order order) {
		List<LineItem> items = order.getItems();
		saleValueForTheDay += totalOrderValue(items);		
		debitFromStore(items);
		String bill = printBill(order);
		
		return bill;
	}
	
	private Double totalOrderValue(List<LineItem> items) {
		Double orderValue = 0.0;
		for (LineItem item: items) {
			orderValue += item.getPrice();
		}
		return orderValue;
	}
	
	private void debitFromStore(List<LineItem> items) {
		for(LineItem item: items) {
			store.debit(item);
		}
	}
	
	private String printBill(Order order) {
		return order.toString();
	}
}
