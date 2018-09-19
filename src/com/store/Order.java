package com.store;

import java.util.List;

import com.store.discount.AffiliatedCustomerDiscount;
import com.store.discount.EmployeeDiscount;
import com.store.discount.ProlongedCustomerDiscount;
import com.store.discount.GroceryDiscount;
import com.store.discount.DiscountInput;
import com.store.discount.OverallBillDiscount;
import com.store.discount.IDiscount;

public class Order {

	private IDiscount percentageDiscount;
	private IDiscount billDiscount;

	private Account account;

	public Order() {
		percentageDiscount = createChainOfRules();
		billDiscount = createBillDiscountRule();
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	private List<LineItem> lineItems;

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public double getTotalPrice() {

		double totalPrice=0f;
		List<LineItem> orderItems = getLineItems();
		for (LineItem lineItem : orderItems) {
			Double price = lineItem.getProduct().getPrice();
			int quantity = lineItem.getQuantity();
			String type = lineItem.getProduct().getType();
			Double prodductPrice = price * quantity;
			Customer customer = getAccount().getCustomer();

			DiscountInput productPriceAfterDiscount = new DiscountInput(customer, prodductPrice, type);
			percentageDiscount.apply(productPriceAfterDiscount);
			billDiscount.apply(productPriceAfterDiscount);
			totalPrice = totalPrice+productPriceAfterDiscount.getProductPrice();
		}
		return totalPrice;

	}

	private IDiscount createChainOfRules() {

		IDiscount groceryDiscount = new GroceryDiscount();
		IDiscount employeeDiscount = new EmployeeDiscount();
		IDiscount affCustomerDiscount = new AffiliatedCustomerDiscount();
		IDiscount existCustomerDiscount = new ProlongedCustomerDiscount();

		groceryDiscount.setNextRule(employeeDiscount);
		employeeDiscount.setNextRule(affCustomerDiscount);
		affCustomerDiscount.setNextRule(existCustomerDiscount);
		

		return groceryDiscount;
	}

	private IDiscount createBillDiscountRule() {
		return new OverallBillDiscount();
	}

}
