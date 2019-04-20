package com.grocery.model;

public class Item {
	private String name;
	private Double price;
	
	public Item(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Item) {
			return ((Item) obj).getName().equals(name);
		}
		return false;	
	}
	
	@Override
	public String toString() {
		return "{Name: " + name + ", Price: " + price +"}";  
	}
	
}
