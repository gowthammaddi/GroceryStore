package com.grocery.customer;

public class Customer {
	private final static Integer seniorCitizenAge = 65; 
	private String name;
	private Integer age;
	private boolean isEmployee;
	
	public Customer(String name,Integer age, boolean isEmployee) {
		this.name = name;
		this.age = age;
		this.isEmployee = isEmployee;
	}
	
	public boolean isSeniorCitizen() {
		return age >= seniorCitizenAge;			
	}
	
	public boolean isEmployeeCustomer() {
		return isEmployee;
	}
	
	public String getName() {
		return name;
	}
}
