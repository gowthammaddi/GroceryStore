package com.grocery.discount;

import com.grocery.model.LineItem;

public interface ItemDiscountCalculator {
	public LineItem applyDiscount(LineItem item);
}
