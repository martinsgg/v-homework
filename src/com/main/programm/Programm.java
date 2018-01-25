package com.main.programm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import com.main.objects.Customer;
import com.main.objects.Furniture;
import com.main.objects.HotDog;
import com.main.objects.Product;
import com.main.objects.Purchase;
import com.main.objects.Textile;

public class Programm {
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	static ArrayList<Product> products = new ArrayList<Product>();
	
	static ArrayList<Purchase> purchases = new ArrayList<Purchase>();
	
	private static String readInput() {
		String input = null;
		try {
			input = System.console().readLine();
			return input;
		} catch (Exception e) {return "";}
	}

	public static void main(String[] args) {
		customers.add(new Customer("Phil Rogers"));
		customers.add(new Customer("Brenda M. Schmidt"));
		
		HashMap<String,BigDecimal> discounts = new HashMap<String,BigDecimal>();
		discounts.put("Furniture", new BigDecimal(25));
		discounts.put("HotDog", new BigDecimal(75));
		customers.add(new Customer("Terrance D. Pfarr",discounts));
		
		//--- Products
		products.add(new Furniture(new BigDecimal(14.52),"Carpet",13354654l,new BigDecimal(5)));
		products.add(new Furniture(new BigDecimal(345),"Wardrobe",13534512114l,new BigDecimal(35)));
		products.add(new HotDog(new BigDecimal(4.67),"Food","vegetarian"));
		products.add(new HotDog(new BigDecimal(7.29),"Food","chili"));
		products.add(new HotDog(new BigDecimal(3.59),"Food","french"));
		products.add(new Textile(new BigDecimal(4.34),"nylon",23566111l,"white"));
		products.add(new Textile(new BigDecimal(0.56),"wool",23566111l,"orange"));
		
		boolean exit = false;
		while(!exit){
			Purchase purchase = null;
			while(true) {
				for(int a=0;a<customers.size();a++) {
					System.out.println(a+":"+customers.get(a).getName());
				}
				System.out.println("Select a customer or write exit to exit:");
				String input = readInput();
				if(input.equals("exit")) {
					exit = true;
					break;
				}
				try {
					purchase = new Purchase(customers.get(Integer.parseInt(input)));
					break;
				} catch (Exception e) {
					System.out.println("Customer not found!");
				}
			}
			if(!exit) {
				Product product = null;
				boolean finish = false;
				while(!finish) {
					while(true) {
						for(int a=0;a<products.size();a++) {
							System.out.println(a+":");
							products.get(a).print();
						}
						System.out.println("Select a product or write finish to end product input:");
						String input = readInput();
						if(input.equals("finish")) {
							finish = true;
							break;
						}
						try {
							product = products.get(Integer.parseInt(input));
							break;
						} catch (Exception e) {
							System.out.println("Product not found!");
						}
					}
					while(true && !finish) {
						System.out.println("Enter a count:");
						String input = readInput();
						try {
							purchase.addPurchase(product, new BigDecimal(Double.parseDouble(input)));
							break;
						} catch (Exception e) {
							System.out.println("Wrong input!");
						}
					}
				}
			}
			if(!exit) {
				while(true) {
					System.out.println("Bill:");
					purchase.print();
					System.out.println("Total:"+purchase.getTotal());
					System.out.println("Has customer paid Y/N:");
					String input = readInput();
					if(input.equals("Y")) {
						purchases.add(purchase);
						break;
					} else {
						break;
					}
				}
			}
		}
		for(Purchase purchase:purchases) {
			purchase.print();
			System.out.println("Paid:" + purchase.getTotal());
			System.out.println("---------------------------------------");
		}
	}

}
