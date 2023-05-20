package com;

public interface Discount {
	float flat_10_discount(float discount);
	float bulk_5_discount(float discount);
	float bulk_10_discount(float discount);
	float tiered_50_discount(float discount);
}


