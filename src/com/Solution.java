package com;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Quantity of Product A:");
		float aquan = scan.nextInt();
		float asubtotal = 20 * aquan;
		System.out.println("Enter the Quantity of Product B:");
		float bquan = scan.nextInt();
		float bsubtotal = 40 * bquan;
		System.out.println("Enter the Quantity of Product C:");
		float cquan = scan.nextInt();
		float csubtotal = 50 * cquan;
		float sub_total = asubtotal + bsubtotal + csubtotal;
		float cart_total = sub_total;
		float total_quantity = aquan + bquan + cquan;
		float discount1 = 0;
		float discount2 = 0;
		float discount3 = 0;
		float discount4 = 0;
		float discount = 0;
		String name1 = "flat_10_discount";
		String name2 = "bulk_5_discount";
		String name3 = "bulk_10_discount";
		String name4 = "tiered_50_discount";
		String name = "No Discounts Applicable";
		scan.close();
		Discount d = new DiscountImpl();

		// Discounts 
		
		if (cart_total > 200) {
			discount1 = d.flat_10_discount(cart_total);

		}
		if (aquan > 10 || bquan > 10 || cquan > 10) {
			float subtotal = 0;
			if (aquan > 10) {
				subtotal = asubtotal;
			} else if (bquan > 10) {
				subtotal = bsubtotal;
			} else {
				subtotal = csubtotal;
			}
			discount2 = d.bulk_5_discount(subtotal);
		}
		if (aquan > 20 || bquan > 20 || cquan > 20) {
			discount3 = d.bulk_10_discount(cart_total);
		}

		if (total_quantity > 30 && (aquan > 15 || bquan > 15 || cquan > 15)) {
			float quantity = 0;
			float price = 0;
			if (aquan > 15) {
				quantity = aquan - 15;
				price = quantity * 20;
				cart_total = price;
			} else if (bquan > 15) {
				quantity = bquan - 15;
				price = quantity * 40;
				cart_total = price;
			} else {
				quantity = cquan - 15;
				price = quantity * 50;
				cart_total = price;
			}
			discount4 = d.tiered_50_discount(cart_total);

		}

		if (discount1 > discount2) {
			if (discount1 > discount3) {
				if (discount1 > discount4) {
					discount = discount1;
					name = name1;
				} else {
					discount = discount4;
					name = name4;
				}
			} else {
				discount = discount3;
				name = name3;
			}
		} else {
			discount = discount2;
			name = name2;
		}

		// gift wrap fee

		float gift_wrap_fee = total_quantity * 1;

		// Shipping fee

				
		int packages = (int) total_quantity / 10 + ((total_quantity % 10)==0? 0:1);
		
		float shipping_fee = packages * 5;
		float total = sub_total - discount + gift_wrap_fee + shipping_fee;

		System.out.println("Product A : " + aquan + "-->" + asubtotal);
		System.out.println("Product B : " + bquan + "-->" + bsubtotal);
		System.out.println("Product C : " + cquan + "-->" + csubtotal);
		System.out.println("Subtotal : " + sub_total);
		if (discount != 0) {
			System.out.println("Discount name : " + name + ", Discount Amount : " + discount);
		}
		else {
			System.out.println("Discount name : Discount Amount Not Applicable");
		}
		System.out.println("Shipping Fee : " + shipping_fee);
		System.out.println("Gift Wrap Fee : " + gift_wrap_fee);
		System.out.println("Total : " + total);

	}
}
