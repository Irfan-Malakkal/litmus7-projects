package com.litmus7.retaildiscount.model.impl;

import com.litmus7.retaildiscount.model.Discountable;

/**
 * Represents a wholesale customer eligible for tiered discount rates.
 * <p>
 * Wholesale customers receive:
 * <ul>
 *   <li>15% discount for purchases of ₹10,000 or more</li>
 *   <li>10% discount for purchases below ₹10,000</li>
 * </ul>
 * </p>
 * 
 * <p>This class implements the {@link Discountable} interface.</p>
 * 
 * @author Muhammed Irfan
 */
public class WholesaleCustomer implements Discountable {

	/**
     * Applies a tiered discount based on the wholesale customer policy.
     *
     * @param totalAmount the original purchase amount
     * @return the final amount after applying the appropriate discount
     */
	@Override
	public double applyDiscount(double totalAmount) {
		double discountRate = totalAmount >= 10000 ? 0.15 : 0.1;
		return totalAmount - (totalAmount * discountRate);
	}

}
