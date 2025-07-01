package com.litmus7.retaildiscount.dto;

/**
 * 
 */
public class PremiumCustomer implements Discountable {

	/**
	 * 
	 */
	@Override
	public double applyDiscount(double totalAmount) {
		double discountRate = totalAmount >= 5000 ? 0.1 : 0.07;
		return totalAmount - (totalAmount * discountRate);
	}
	
}
