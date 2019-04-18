package com.grocery.pricing;

import java.util.HashMap;
import java.util.Map;

import com.grocery.customer.Customer;
import com.grocery.item.LineItem;
import com.grocery.item.Product;

public class Pricing {
	
	private static Integer seniorCitizen = 5;
	private static Integer employee = 10;
	private static Map<String, Integer> productDiscountMap = initProductDiscount();
	
	public static LineItem discountedItem(Customer customer, LineItem item) {
		Double totalDiscountPercent = 0.0;
		LineItem discountedItem = item;
		
		if (customer.isSeniorCitizen()) {
			totalDiscountPercent += seniorCitizen;
		}
		
		if (customer.isEmployeeCustomer()) {
			totalDiscountPercent += employee;
		}
		
		Product product = item.getProduct();
		if (productDiscountMap.containsKey(product.getName())) {
			totalDiscountPercent += productDiscountMap.get(product.getName());
		}
		
		discountedItem.setPrice(item.getPrice() * ( 1-(totalDiscountPercent/100) ));
		
		return discountedItem;
	}

	private static Map<String, Integer> initProductDiscount() {
		productDiscountMap = new HashMap<String, Integer>();
		productDiscountMap.put("lays", 5);
		
		return productDiscountMap; 
	}
}
