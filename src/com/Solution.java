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
		float discount1 = 0, discount2 = 0, discount3 = 0, discount4 = 0, discount = 0;

		String name1 = "flat_10_discount";
		String name2 = "bulk_5_discount";
		String name3 = "bulk_10_discount";
		String name4 = "tiered_50_discount";
		String name = "";
		scan.close();

		Discount d = new DiscountImpl();

		// Available Discounts
		// Discount 1

		if (cart_total > 200) {
			discount1 = d.flat_10_discount(cart_total);

		}

		// Discount 2

		if (aquan > 10 || bquan > 10 || cquan > 10) {
			float d1 = 0, d2 = 0, d3 = 0;
			if (aquan > 10) {
				d1 = d.bulk_5_discount(asubtotal);
			}
			if (bquan > 10) {
				d2 = d.bulk_5_discount(bsubtotal);
			}
			if (cquan > 10) {
				d3 = d.bulk_5_discount(csubtotal);
			}

			if (d1 > d2 && d1 > d3) {
				discount2 = d1;
			} else if (d2 > d1 && d2 > d3) {
				discount2 = d2;
			} else {
				discount2 = d3;
			}
		}

		// Discount 3

		if (aquan > 20 || bquan > 20 || cquan > 20) {
			discount3 = d.bulk_10_discount(cart_total);
		}

		// Discount 4

		if (total_quantity > 30 && (aquan > 15 || bquan > 15 || cquan > 15)) {
			float dis1 = 0, dis2 = 0, dis3 = 0;
			if (aquan > 15) {
				cart_total = (aquan - 15) * 20;
				dis1 = d.tiered_50_discount(cart_total);
			}
			if (bquan > 15) {
				cart_total = (bquan - 15) * 40;
				dis2 = d.tiered_50_discount(cart_total);
			}
			if (cquan > 15) {
				cart_total = (cquan - 15) * 50;
				dis3 = d.tiered_50_discount(cart_total);
			}

			if (dis1 > dis2 && dis1 > dis3) {
				discount4 = dis1;
			} else if (dis2 > dis1 && dis2 > dis3) {
				discount4 = dis2;
			} else {
				discount4 = dis3;
			}
		}

		// Finding most favourable discounts

		if (discount1 > discount2) {
			if (discount1 > discount3) {
				if (discount1 > discount4) {
					discount = discount1;
					name = name1;
				} else {
					discount = discount4;
					name = name4;
				}
			} else if (discount3 > discount4) {
				discount = discount3;
				name = name3;
			} else {
				discount = discount4;
				name = name4;
			}
		} else if (discount2 > discount3) {
			if (discount2 > discount4) {
				discount = discount2;
				name = name2;
			} else {
				discount = discount4;
				name = name4;
			}
		} else if (discount3 > discount4) {
			discount = discount3;
			name = name3;
		} else {
			discount = discount4;
			name = name4;
		}

		// Gift wrap fee

		float gift_wrap_fee = total_quantity * 1;

		// Shipping fee

		int packages = (int) total_quantity / 10 + ((total_quantity % 10) == 0 ? 0 : 1);
		float shipping_fee = packages * 5;
		float total = sub_total - discount + gift_wrap_fee + shipping_fee;

		// Output

		System.out.println("Product A : " + aquan + "-->" + asubtotal);
		System.out.println("Product B : " + bquan + "-->" + bsubtotal);
		System.out.println("Product C : " + cquan + "-->" + csubtotal);
		System.out.println("Subtotal : " + sub_total);
		if (discount != 0) {
			System.out.println("Discount name : " + name + ", Discount Amount : " + discount);
		} else {
			System.out.println("No Discounts Applicable");
			System.out.println("Discount Amount : " + discount);
		}
		System.out.println("Shipping Fee : " + shipping_fee);
		System.out.println("Gift Wrap Fee : " + gift_wrap_fee);
		System.out.println("Total : " + total);

	}
}
