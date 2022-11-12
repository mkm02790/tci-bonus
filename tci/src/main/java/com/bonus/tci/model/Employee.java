package com.bonus.tci.model;

public class Employee {
	
	String name;
	long amount;
	
	public Employee() {
		super();
		
	}
	public Employee(String name, long d) {
		super();
		this.name = name;
		this.amount = d;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	}


