package com.store.discount;

public interface IDiscount {
	
	public void setNextRule(IDiscount nextRule);
    public abstract boolean apply(DiscountInput inputDataForDiscountRules);

}
