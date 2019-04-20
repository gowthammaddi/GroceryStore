package com.grocery.discount;

import com.grocery.model.Customer;
import com.grocery.model.Order;

public class SeniorCitizenOrderDiscountCalculator implements OrderDiscountCalculator {

	private Double discountPercentage = 7d;
	private Integer seniorCitizenAge = 65;

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
