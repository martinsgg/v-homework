package com.main.objects;

import java.math.BigDecimal;

import com.main.interfaces.Printable;

public class HotDog extends Product implements Printable {
	private String Flavor;
	
	public HotDog(BigDecimal price, String description, String flavor) {
		super(price, description);
		setFlavor(flavor);
	}

	public String getFlavor() {
		return Flavor;
	}

	public void setFlavor(String flavor) {
		Flavor = flavor;
	}
	
	@Override
	public void printProductSpecifics() {
		System.out.println("Flavor: " + getFlavor());
	}
}
