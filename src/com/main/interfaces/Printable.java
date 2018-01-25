package com.main.interfaces;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface Printable {
	public BigDecimal getPrice();
	public String getDescription();
	
	public default void print() {
		System.out.println("Category: " + this.getClass().getSimpleName());
		System.out.println("Price: " + getPrice().setScale(2, RoundingMode.CEILING));
		System.out.println("Description: " + getDescription());
		printProductSpecifics();
	};
	
	public void printProductSpecifics();
}
