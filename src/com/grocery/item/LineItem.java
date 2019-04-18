package com.grocery.item;

import com.grocery.init.GroceryStore;

public class LineItem {
	private Product product; 
	private Double price;
	private Integer quantity;
	
	public LineItem(Product product, Double price, Integer quantity) {
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}
	
	public LineItem(Product product, Integer quantity) {
		this.product = product;
		this.price = GroceryStore.getInstance().getPrice(product);
		this.quantity = quantity;
	}
	
	public LineItem(Product product) {
		this.product = product;
		this.price = GroceryStore.getInstance().getPrice(product);
		this.quantity = 1;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public boolean reduceQuantity(Integer quantity) {
		Integer latestQuantity = this.quantity - quantity;
		if (latestQuantity >= 0) {
			this.quantity = latestQuantity;
			return true;
		}
		return false;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double totalItemPrice() {
		return Double.valueOf(quantity * price);
	}
	
	@Override
	public String toString() {
		return "Product: " + product + ", Price: " + price + ", Quantity: " + quantity;
	}
	
}
