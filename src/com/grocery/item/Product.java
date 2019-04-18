package com.grocery.item;

public class Product {
	private String name;
	private String supplier;
	
	public Product(String name, String supplier) {
		this.name = name;
		this.supplier = supplier;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSupplier() {
		return supplier;
	}
	
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Product) {
			return ((Product) obj).getName().equals(name);
		}
		return false;	
	}
	
	@Override
	public String toString() {
		return "{Name: " + name + ", Supplier: " + supplier +"}";  
	}
	
}
