package com.store.discount;

public class GroceryDiscount extends AbstractIDiscount {

	public boolean apply(DiscountInput inputDiscount) {
		if (inputDiscount.getProductType().equalsIgnoreCase("GROCERY")) {
			return true;
		}
		return applyNextRuleIfExist(inputDiscount);

	}
}
