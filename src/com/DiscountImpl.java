package com;

public class DiscountImpl implements Discount {

	// Implementing the inherited abstract methods 
	
	@Override
	public float flat_10_discount(float discount) {
		discount = 10;
		return discount;
	}

	@Override
	public float bulk_5_discount(float discount) {
		discount = discount * 5 / 100;
		return discount;
	}

	@Override
	public float bulk_10_discount(float discount) {
		discount = discount * 10 / 100;
		return discount;
	}

	@Override
	public float tiered_50_discount(float discount) {
		discount = discount * 50 / 100;
		return discount ;

	}
}
