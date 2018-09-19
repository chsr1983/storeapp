package com.store.discount;

public abstract class AbstractIDiscount implements IDiscount {

	protected IDiscount nextRule;

	public void setNextRule(IDiscount nextRule) {
		this.nextRule = nextRule;
	}

	public boolean applyNextRuleIfExist(DiscountInput inputDiscount) {
		if (this.nextRule != null) {
			return this.nextRule.apply(inputDiscount);
		}
		return false;
	}

}
