package com.store.discount;

public class OverallBillDiscount extends AbstractIDiscount {

	private static final int OVERLLBILL_DISCOUNT = 5;

	public boolean apply(DiscountInput inputDiscount) {
		if (applyDiscuountIfEmployee(inputDiscount)) {
			return true;
		}
		return applyNextRuleIfExist(inputDiscount);

	}

	private boolean applyDiscuountIfEmployee(DiscountInput inputDiscount) {
		if(inputDiscount.getProductPrice()>=100){
			double productPrice = inputDiscount.getProductPrice();
			int i = (int)(productPrice/100);
			productPrice=productPrice-(i*OVERLLBILL_DISCOUNT);
			inputDiscount.setProductPrice(productPrice);
			return true;
		}
		return false;
	}
}
