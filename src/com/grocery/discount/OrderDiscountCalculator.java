package com.grocery.discount;

import com.grocery.model.Order;

public interface OrderDiscountCalculator {
	public Order applyDiscount(Order order);
}
