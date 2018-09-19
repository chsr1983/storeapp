package com.store.discount;

public class AffiliatedCustomerDiscount  extends AbstractIDiscount {

	private static final int AFFILIATED_CUSTOMER_DISCOUNT = 10;

	public boolean apply(DiscountInput inputDiscount) {
		if (applyDiscuountIfAffiliated(inputDiscount)) {
			return true;
		}
		return applyNextRuleIfExist(inputDiscount);

	}

	private boolean applyDiscuountIfAffiliated(DiscountInput inputDiscount) {
		if(inputDiscount.getCustomer().isAffiliatedCustomer()){
			double productPrice = inputDiscount.getProductPrice();
			productPrice=(productPrice * (100f-AFFILIATED_CUSTOMER_DISCOUNT))/100;
			inputDiscount.setProductPrice(productPrice);
			return true;
		}
		return false;
	}
}
