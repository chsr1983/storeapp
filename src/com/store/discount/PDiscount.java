package com.store.discount;

public interface PDiscount {
	
	public void setNextRule(PDiscount nextRule);
    public abstract boolean apply(DiscountInput inputDataForDiscountRules);

}
