package com.store;

import java.util.List;

import com.store.discount.AffiliatedCustomerDiscount;
import com.store.discount.EmployeeDiscount;
import com.store.discount.ProlongedCustomerDiscount;
import com.store.discount.GroceryDiscount;
import com.store.discount.DiscountInput;
import com.store.discount.OverallBillDiscount;
import com.store.discount.PDiscount;

public class Order {

	private PDiscount percentageDiscount;
	private PDiscount billDiscount;

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

	private List<LineItem> LineItems;

	public List<LineItem> getLineItems() {
		return LineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		LineItems = lineItems;
	}

	public double getTotalPrice() {

		double totalPrice=0f;
		for (LineItem lineItem : LineItems) {
			Double price = lineItem.getProduct().getPrice();
			int quantity = lineItem.getQuantity();
			String type = lineItem.getProduct().getType();
			Double prodductPrice = price * quantity;
			Customer customer = this.account.getCustomer();

			DiscountInput productPriceAfterDiscount = new DiscountInput(customer, prodductPrice, type);
			percentageDiscount.apply(productPriceAfterDiscount);
			billDiscount.apply(productPriceAfterDiscount);
			totalPrice = totalPrice+productPriceAfterDiscount.getProductPrice();
		}
		return totalPrice;

	}

	private PDiscount createChainOfRules() {

		PDiscount groceryDiscount = new GroceryDiscount();
		PDiscount employeeDiscount = new EmployeeDiscount();
		PDiscount affCustomerDiscount = new AffiliatedCustomerDiscount();
		PDiscount existCustomerDiscount = new ProlongedCustomerDiscount();

		groceryDiscount.setNextRule(employeeDiscount);
		employeeDiscount.setNextRule(affCustomerDiscount);
		affCustomerDiscount.setNextRule(existCustomerDiscount);
		

		return groceryDiscount;
	}

	private PDiscount createBillDiscountRule() {
		return new OverallBillDiscount();
	}

}
