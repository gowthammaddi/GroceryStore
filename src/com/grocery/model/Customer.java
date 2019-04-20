package com.grocery.model;

public class Customer {
	private String name;
	private Integer age;
	
	public Customer(String name,Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getAge() {
		return age;
	}
}
