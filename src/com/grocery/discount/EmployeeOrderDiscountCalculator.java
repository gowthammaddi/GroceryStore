package com.grocery.discount;

import com.grocery.model.Order;

public class EmployeeOrderDiscountCalculator implements OrderDiscountCalculator{

	private Double discountPercentage = 10d;

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
