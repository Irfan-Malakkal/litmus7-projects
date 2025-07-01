package com.litmus7.retaildiscount.dto;


public class RegularCustomer implements Discountable {

	@Override
	public double applyDiscount(double totalAmount) {
		return totalAmount - (totalAmount * 0.05);
	}

}
