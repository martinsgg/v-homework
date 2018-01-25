package com.main.objects;

import java.math.BigDecimal;
import java.util.HashMap;

public class Customer {
	private String Name;
	private boolean Member = false;
	private HashMap<String,BigDecimal> Discounts; //value in percents - example - Furniture 25% will be Furniture,25
	
	public Customer(String name) {
		this.setName(name);
	}
	
	public Customer(String name,HashMap<String,BigDecimal> discounts) {
		this.setName(name);
		this.setIsMember(true);
		this.setDiscounts(discounts);
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public boolean IsMember() {
		return Member;
	}
	public void setIsMember(boolean isMember) {
		Member = isMember;
	}
	public HashMap<String, BigDecimal> getDiscounts() {
		return Discounts;
	}
	public void setDiscounts(HashMap<String, BigDecimal> discounts) {
		Discounts = discounts;
	}
	public BigDecimal getDiscount(String category) {
		if(this.IsMember()) {
			return Discounts.get(category);
		} else {
			return new BigDecimal(0);
		}
	}
}
