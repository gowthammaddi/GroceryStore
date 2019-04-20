package com.grocery.discount;

import java.util.HashMap;

import com.grocery.model.LineItem;

public class ItemCategoryDiscountCalculator implements ItemDiscountCalculator {

	/* Eg.,
	 * Category, discount%
	 * lays, 5%
	 * amul, 13%
	 */
	HashMap<String, Double> discountMap = new HashMap<String, Double>();
	
	public ItemCategoryDiscountCalculator() {
		discountMap.put("lays", 5d);
		discountMap.put("amul", 13d);
	}
	
	@Override
	public LineItem applyDiscount(LineItem item) {
		if (discountMap.containsKey(item.getItem().getName())) {
			item.setPrice(item.getPrice() * (1 - ( discountMap.get(item.getItem().getName())/100 )));
		}
		return item;
	}

}
