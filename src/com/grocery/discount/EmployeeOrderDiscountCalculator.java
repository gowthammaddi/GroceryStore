package com.grocery.discount;

import java.io.FileInputStream;
import java.util.Properties;

import com.grocery.model.Order;

public class EmployeeOrderDiscountCalculator implements OrderDiscountCalculator{

	private static Double discountPercentage;

	public EmployeeOrderDiscountCalculator() {
		Properties property = new Properties();
		try {
			property.load(new FileInputStream("./resources/discount.properties"));
			
			discountPercentage = Double.parseDouble(property.getProperty("employeeOrderDiscount"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Order applyDiscount(Order order) {
		Double totalOrderValue = order.getTotalOrderValue();
		Double discountedTotalOrderValue = totalOrderValue;
		if (order.isEmployeeOrder()) {
			discountedTotalOrderValue = totalOrderValue * ( 1-discountPercentage/100 );
		}
		
		order.setTotalOrderValue(discountedTotalOrderValue);
		
		return order;
	}

}
