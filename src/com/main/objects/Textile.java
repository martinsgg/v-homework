package com.main.objects;

import java.math.BigDecimal;

import com.main.interfaces.Printable;

public class Textile extends Product implements Printable {
	private long Number;
	private String color;
	
	public Textile(BigDecimal price, String description, long number, String color) {
		super(price, description);
		setNumber(number);
		setColor(color);
	}
	
	public long getNumber() {
		return Number;
	}
	public void setNumber(long number) {
		Number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public void printProductSpecifics() {
		System.out.println("Number: " + getNumber());
		System.out.println("Color: " + getColor());
	}
}
