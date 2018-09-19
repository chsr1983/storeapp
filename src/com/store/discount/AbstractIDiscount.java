package com.store.discount;

public abstract class AbstractIDiscount implements PDiscount {

	protected PDiscount nextRule;

	public void setNextRule(PDiscount nextRule) {
		this.nextRule = nextRule;
	}

	public boolean applyNextRuleIfExist(DiscountInput inputDiscount) {
		if (this.nextRule != null) {
			return this.nextRule.apply(inputDiscount);
		}
		return false;
	}

}
