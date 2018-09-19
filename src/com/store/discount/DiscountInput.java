package com.store.discount;

import com.store.Customer;

public class DiscountInput {

	private Customer customer;
	private double productPrice;
	private String productType;

	public DiscountInput(Customer customer, Double totalPrice, String type) {

		this.customer = customer;
		this.productPrice = totalPrice;
		this.productType = type;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}
