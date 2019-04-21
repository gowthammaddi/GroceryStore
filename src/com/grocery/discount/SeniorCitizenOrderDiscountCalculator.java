package com.grocery.discount;

import java.io.FileInputStream;
import java.util.Properties;

import com.grocery.model.Customer;
import com.grocery.model.Order;

public class SeniorCitizenOrderDiscountCalculator implements OrderDiscountCalculator {

	private static Double discountPercentage;
	private static Integer seniorCitizenAge;

	public SeniorCitizenOrderDiscountCalculator() {
		Properties property = new Properties();
		try {
			property.load(new FileInputStream("./resources/discount.properties"));
			
			discountPercentage = Double.parseDouble(property.getProperty("scOrderDiscount"));
			seniorCitizenAge = Integer.parseInt(property.getProperty("scAge"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Order applyDiscount(Order order) {
		Double totalOrderValue = order.getTotalOrderValue();
		Double discountedTotalOrderValue = totalOrderValue;
		
		Customer customer = order.getCustomer();
		Integer customerAge = customer.getAge();
		if (customerAge > seniorCitizenAge) {
			discountedTotalOrderValue = totalOrderValue * ( 1-discountPercentage/100 );
		}
		
		order.setTotalOrderValue(discountedTotalOrderValue);
		
		return order;
	}

}
