package com.main.objects;

import java.math.BigDecimal;

import com.main.interfaces.Printable;

public abstract class Product implements Printable{
	private BigDecimal Price;
	private String Description;
	
	public Product(BigDecimal price, String description) {
		setPrice(price);
		setDescription(description);
	}
	
	public BigDecimal getPrice() {
		return Price;
	}
	public void setPrice(BigDecimal price) {
		this.Price = price;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
}
