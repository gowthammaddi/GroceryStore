package com.grocery.discount;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

import com.grocery.model.Item;
import com.grocery.model.LineItem;

public class ItemCategoryDiscountCalculator implements ItemDiscountCalculator {

	private static HashMap<String, Double> discountMap = new HashMap<String, Double>();
	
	public ItemCategoryDiscountCalculator() {
		Properties property = new Properties();
		try {
			property.load(new FileInputStream("./resources/discount.properties"));
			
			String[] productNames = property.getProperty("productName").split(",");
			String[] productPrices = property.getProperty("productDiscount").split(",");

			for (int i=0; i<productNames.length; i++) {
				String productName = productNames[i];
				Double productDiscount = Double.parseDouble(productPrices[i]);
				
				discountMap.put(productName, productDiscount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public LineItem applyDiscount(LineItem item) {
		if (discountMap.containsKey(item.getItem().getName())) {
			item.setPrice(item.getPrice() * (1 - ( discountMap.get(item.getItem().getName())/100 )));
		}
		return item;
	}

}
