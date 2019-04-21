package com.grocery.init;

import com.grocery.model.Customer;
import com.grocery.model.Item;
import com.grocery.model.LineItem;

import java.util.ArrayList;
import java.util.List;

import com.grocery.billing.Register;

public class Main {

	public static void main(String[] args) {
		Item lays = new Item("lays", 10d);
		Item amul = new Item("amul", 24d);
		Item medimix = new Item("medimix", 34d);
		
		List<LineItem> itemList = new ArrayList<LineItem>();
		itemList.add(new LineItem(lays, 2));
		itemList.add(new LineItem(amul, 5));
		itemList.add(new LineItem(medimix, 1));
		
		Customer customer = new Customer("Gowtham", 23);
		
		Register reg1 = new Register();
		System.out.println(reg1.confirmOrder(reg1.createOrder(itemList, customer, false)));
//		System.out.println(Inventory.getInstance().printInventory());
		
	}

}
