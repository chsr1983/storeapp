package com.store;

import java.util.Date;
import java.util.Random;

public class Customer {

	private String name;
	private Integer age;
	private String address;
	
	private boolean isEmployee;
	private boolean isAffiliatedCustomer;
	
	public boolean isEmployee() {
		return isEmployee;
	}

	public Customer setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
		return this;
	}

	public boolean isAffiliatedCustomer() {
		return isAffiliatedCustomer;
	}

	public Customer setAffiliatedCustomer(boolean isAffiliatedCustomer) {
		this.isAffiliatedCustomer = isAffiliatedCustomer;
		return this;
	}

	private Account account;

	public Customer build() {
		this.account = new Account();
		account.setCreatedDate(new Date());
		this.account.setId(new Random().toString());
		return this;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getAddress() {
		return address;
	}

	public Customer setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getName() {
		return name;
	}

	public Customer setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public Customer setAge(Integer age) {
		this.age = age;
		return this;
	}

}
