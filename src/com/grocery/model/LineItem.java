package com.grocery.model;

public class LineItem {
	private Item item; 
	private Double price;
	private Integer quantity;
	
	public LineItem(Item item, Integer quantity) {
		this.item = item;
		this.price = item.getPrice() * quantity;
		this.quantity = quantity;
	}
	
	public LineItem(Item item) {
		this.item = item;
		this.price = item.getPrice();
		this.quantity = 1;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getPrice() {
		return price;
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
	
	@Override
	public String toString() {
		return "Item Name : " + item.getName() + ", Price: " + item.getPrice() + ", Quantity: " + quantity + ", Total Price: " + price;  
	}
	
}
