package com.litmus7.retaildiscount.dto;


public class WholesaleCustomer implements Discountable {

	@Override
	public double applyDiscount(double totalAmount) {
		double discountRate = totalAmount >= 10000 ? 0.15 : 0.1;
		return totalAmount - (totalAmount * discountRate);
	}

}
