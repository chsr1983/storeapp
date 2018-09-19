package com.store;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestStoreOrders {

	@Test
	public void testEmployeeNTotalBillDiscountForGroceryNNonGrocery() {
		Customer customer1 = new Customer().setName("customer1").setAddress("bangalore").setAge(2).setEmployee(true).build();

		Order order1 = new Order();
		List<LineItem> lineItems = new ArrayList<>();
		LineItem lineItem = new LineItem();

		Product product1 = new Product("product1", "grocery", 100);
		Product product2 = new Product("product2", "non grocery", 150);
		lineItem.setProduct(product1);
		lineItem.setQuantity(2);

		LineItem lineItem2 = new LineItem();
		lineItem2.setProduct(product2);
		lineItem2.setQuantity(1);

		lineItems.add(lineItem);
		lineItems.add(lineItem2);

		order1.setLineItems(lineItems);
		Account account = customer1.getAccount();
		account.setCustomer(customer1);
		account.setOrder(order1);
		order1.setAccount(account);

		double totalPrice = account.getOrder().getTotalPrice();

		double expected=290;
		Assert.assertEquals(expected, totalPrice,0);
	}
	
	@Test
	public void testAffiliatedNTotalBillDiscountForGroceryNNonGrocery() {
		Customer customer1 = new Customer().setName("customer1").setAddress("bangalore").setAge(2).setAffiliatedCustomer(true).build();

		Order order1 = new Order();
		List<LineItem> lineItems = new ArrayList<>();
		LineItem lineItem = new LineItem();

		Product product1 = new Product("product1", "grocery", 100);
		Product product2 = new Product("product2", "non grocery", 150);
		lineItem.setProduct(product1);
		lineItem.setQuantity(2);

		LineItem lineItem2 = new LineItem();
		lineItem2.setProduct(product2);
		lineItem2.setQuantity(1);

		lineItems.add(lineItem);
		lineItems.add(lineItem2);

		order1.setLineItems(lineItems);
		Account account = customer1.getAccount();
		account.setCustomer(customer1);
		account.setOrder(order1);
		order1.setAccount(account);

		double totalPrice = account.getOrder().getTotalPrice();

		double expected=320;
		Assert.assertEquals(expected, totalPrice,0);
	}
	@Test
	public void testProlongedCustomerNTotalBillDiscountForGroceryNNonGrocery() {
		Customer customer1 = new Customer().setName("customer1").setAddress("bangalore").setAge(2).build();

		Order order1 = new Order();
		List<LineItem> lineItems = new ArrayList<>();
		LineItem lineItem = new LineItem();

		Product product1 = new Product("product1", "grocery", 100);
		Product product2 = new Product("product2", "non grocery", 150);
		lineItem.setProduct(product1);
		lineItem.setQuantity(2);

		LineItem lineItem2 = new LineItem();
		lineItem2.setProduct(product2);
		lineItem2.setQuantity(1);

		lineItems.add(lineItem);
		lineItems.add(lineItem2);

		order1.setLineItems(lineItems);
		Account account = customer1.getAccount();
		account.setCustomer(customer1);
		account.setOrder(order1);
		order1.setAccount(account);

		double totalPrice = account.getOrder().getTotalPrice();

		double expected=327.5;
		Assert.assertEquals(expected, totalPrice,0);
	}
	@Test
	public void testForNoDiscountAtAll() {
		Customer customer1 = new Customer().setName("customer1").setAddress("bangalore").setAge(1).build();

		Order order1 = new Order();
		List<LineItem> lineItems = new ArrayList<>();
		LineItem lineItem = new LineItem();

		Product product1 = new Product("product1", "grocery", 10);
		Product product2 = new Product("product2", "non grocery", 20);
		lineItem.setProduct(product1);
		lineItem.setQuantity(2);

		LineItem lineItem2 = new LineItem();
		lineItem2.setProduct(product2);
		lineItem2.setQuantity(1);

		lineItems.add(lineItem);
		lineItems.add(lineItem2);

		order1.setLineItems(lineItems);
		Account account = customer1.getAccount();
		account.setCustomer(customer1);
		account.setOrder(order1);
		order1.setAccount(account);

		double totalPrice = account.getOrder().getTotalPrice();

		double expected=40;
		Assert.assertEquals(expected, totalPrice,0);
	}
	@Test
	public void testOnlyTotalBillDiscount() {
		Customer customer1 = new Customer().setName("customer1").setAddress("bangalore").setAge(1).build();

		Order order1 = new Order();
		List<LineItem> lineItems = new ArrayList<>();
		LineItem lineItem = new LineItem();

		Product product1 = new Product("product1", "grocery", 100);
		Product product2 = new Product("product2", "grocery", 150);
		lineItem.setProduct(product1);
		lineItem.setQuantity(2);

		LineItem lineItem2 = new LineItem();
		lineItem2.setProduct(product2);
		lineItem2.setQuantity(1);

		lineItems.add(lineItem);
		lineItems.add(lineItem2);

		order1.setLineItems(lineItems);
		Account account = customer1.getAccount();
		account.setCustomer(customer1);
		account.setOrder(order1);
		order1.setAccount(account);

		double totalPrice = account.getOrder().getTotalPrice();

		double expected=335;
		Assert.assertEquals(expected, totalPrice,0);
	}
	@Test
	public void testOnlyEmployeeDiscount() {
		Customer customer1 = new Customer().setName("customer1").setAddress("bangalore").setAge(1).setEmployee(true).build();

		Order order1 = new Order();
		List<LineItem> lineItems = new ArrayList<>();
		LineItem lineItem = new LineItem();

		Product product1 = new Product("product1", "Non grocery", 40);
		lineItem.setProduct(product1);
		lineItem.setQuantity(2);

		lineItems.add(lineItem);

		order1.setLineItems(lineItems);
		Account account = customer1.getAccount();
		account.setCustomer(customer1);
		account.setOrder(order1);
		order1.setAccount(account);

		double totalPrice = account.getOrder().getTotalPrice();

		double expected=56;
		Assert.assertEquals(expected, totalPrice,0);
	}
	@Test
	public void testOnlyAffiliatedCustomerDiscount() {
		Customer customer1 = new Customer().setName("customer1").setAddress("bangalore").setAge(1).setAffiliatedCustomer(true).build();

		Order order1 = new Order();
		List<LineItem> lineItems = new ArrayList<>();
		LineItem lineItem = new LineItem();

		Product product1 = new Product("product1", "Non grocery", 40);
		lineItem.setProduct(product1);
		lineItem.setQuantity(2);

		lineItems.add(lineItem);

		order1.setLineItems(lineItems);
		Account account = customer1.getAccount();
		account.setCustomer(customer1);
		account.setOrder(order1);
		order1.setAccount(account);

		double totalPrice = account.getOrder().getTotalPrice();

		double expected=72;
		Assert.assertEquals(expected, totalPrice,0);
	}
	@Test
	public void testOnlyProlongedCustomerDiscount() {
		Customer customer1 = new Customer().setName("customer1").setAddress("bangalore").setAge(2).build();

		Order order1 = new Order();
		List<LineItem> lineItems = new ArrayList<>();
		LineItem lineItem = new LineItem();

		Product product1 = new Product("product1", "Non grocery", 40);
		lineItem.setProduct(product1);
		lineItem.setQuantity(2);

		lineItems.add(lineItem);

		order1.setLineItems(lineItems);
		Account account = customer1.getAccount();
		account.setCustomer(customer1);
		account.setOrder(order1);
		order1.setAccount(account);

		double totalPrice = account.getOrder().getTotalPrice();

		double expected=76;
		Assert.assertEquals(expected, totalPrice,0);
	}

}
