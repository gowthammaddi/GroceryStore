package com.grocery.init;

import com.grocery.billing.Order;
import com.grocery.billing.Register;
import com.grocery.customer.Customer;
import com.grocery.item.LineItem;
import com.grocery.item.Product;

public class Main {

	public static void main(String[] args) {
		Product lays = new Product("lays", "gowtham");
		Product amul = new Product("amul", "maddi");
		
		LineItem item1 = new LineItem(lays, 2);
		LineItem item2 = new LineItem(amul, 5);
		
		Order order1 = new Order();
		order1.addItem(item1);
		order1.addItem(item2);
		
		Customer gowtham = new Customer("Gowtham", 24, false);
		
		Register reg1 = new Register();
		System.out.println(reg1.confirmOrder(gowtham, order1));
	}

}
