package com.store.discount;

public class EmployeeDiscount extends AbstractIDiscount {

	private static int  EMPLOYEE_DISCOUNT = 30;

	public boolean apply(DiscountInput inputDiscount) {
		if (applyDiscuountIfEmployee(inputDiscount)) {
			return true;
		}
		return applyNextRuleIfExist(inputDiscount);

	}

	private boolean applyDiscuountIfEmployee(DiscountInput inputDiscount) {
		if (inputDiscount.getCustomer().isEmployee()) {
			double productPrice = inputDiscount.getProductPrice();
			productPrice = (productPrice * (100 - EMPLOYEE_DISCOUNT))/100;
			inputDiscount.setProductPrice(productPrice);
			return true;
		}
		return false;
	}
}
