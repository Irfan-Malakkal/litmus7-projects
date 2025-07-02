package com.litmus7.retaildiscount.dto;

/**
 * Represents a regular customer who receives a flat discount rate.
 * <p>
 * Regular customers are eligible for a fixed 5% discount on all purchases,
 * regardless of the purchase amount.
 * </p>
 * 
 * <p>This class implements the {@link Discountable} interface.</p>
 * 
 * @author Muhammed Irfan
 */
public class RegularCustomer implements Discountable {

	 /**
     * Applies a flat 5% discount for regular customers.
     *
     * @param totalAmount the original purchase amount
     * @return the final amount after applying the 5% discount
     */
	@Override
	public double applyDiscount(double totalAmount) {
		return totalAmount - (totalAmount * 0.05);
	}

}
