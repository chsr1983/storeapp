package com.store.discount;

public class ProlongedCustomerDiscount  extends AbstractIDiscount {

	private static final int CUSTOMER_DISCOUNT = 5;

	public boolean apply(DiscountInput inputDiscount) {
		if (applyDiscuountIfProlongedCustomer(inputDiscount)) {
			return true;
		}
		return applyNextRuleIfExist(inputDiscount);

	}

	private boolean applyDiscuountIfProlongedCustomer(DiscountInput inputDiscount) {
		if(inputDiscount.getCustomer().getAge()>=2){
			double productPrice = inputDiscount.getProductPrice();
			productPrice=(productPrice * (100-CUSTOMER_DISCOUNT))/100;
			inputDiscount.setProductPrice(productPrice);
			return true;
		}
		return false;
	}
}
