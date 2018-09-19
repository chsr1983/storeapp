package com.store;

public class Product {

	private String id;
	private String name;

	private String type;
	private double price;

	public double getPrice() {
		return price;
	}

	public Product(String id, String type, double price) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
	}

	public String getType() {
		return type;
	}

}
