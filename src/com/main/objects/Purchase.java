package com.main.objects;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

public class Purchase {
	private Customer customer = null;
	private Map<Product,BigDecimal> purchasesProducts = new LinkedHashMap<Product,BigDecimal>();
	
	public Purchase(Customer customer) {
		this.customer = customer;
	}
	
	public void addPurchase(Product product,BigDecimal count) {
		 purchasesProducts.put(product, count);
	}
	
	public void print() {
		System.out.println("---------------------------------------");
		System.out.println("Customer: " + customer.getName());
		System.out.println("Products: ");
		for (Map.Entry<Product,BigDecimal> entry : purchasesProducts.entrySet()) {
		    entry.getKey().print();
		    System.out.println("Count:" + entry.getValue());
		}
		System.out.println("---------------------------------------");
	}
	
	public BigDecimal getTotal() {
		 BigDecimal bill = new BigDecimal(0);
		 for (Map.Entry<Product,BigDecimal> entry : purchasesProducts.entrySet()) {
			 BigDecimal discount = new BigDecimal(1);
			 try {
				 discount = new BigDecimal(100).subtract(customer.getDiscount(entry.getKey().getClass().getSimpleName())).divide(new BigDecimal(100));
			 } catch(Exception e) {}
			
			bill = bill.add(entry.getKey().getPrice().multiply(entry.getValue()).multiply(discount));
		 }
		 return bill.setScale(2, RoundingMode.CEILING);
	}
	
}
