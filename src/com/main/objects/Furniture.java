package com.main.objects;

import java.math.BigDecimal;

import com.main.interfaces.Printable;

public class Furniture extends Product implements Printable {
	private long number;
	private BigDecimal weight;
	
	public Furniture(BigDecimal price, String description, long number, BigDecimal weight) {
		super(price, description);
		setNumber(number);
		setWeight(weight);
	}
	
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
	@Override
	public void printProductSpecifics() {
		System.out.println("Number: " + getNumber());
		System.out.println("Weight: " + getWeight());
	}
}
