package com.litmus7.retaildiscount.dto;

/**
 * Represents a premium customer eligible for specific discount rates.
 * <p>
 * Premium customers receive:
 * <ul>
 *   <li>10% discount for purchases of ₹5000 or more</li>
 *   <li>7% discount for purchases below ₹5000</li>
 * </ul>
 * </p>
 * 
 * <p>This class implements the {@link Discountable} interface.</p>
 * 
 * @author Muhammed Irfan
 */
public class PremiumCustomer implements Discountable {

	/**
     * Applies a discount based on the premium customer policy.
     *
     * @param totalAmount the original purchase amount
     * @return the final amount after applying the discount
     */
	@Override
	public double applyDiscount(double totalAmount) {
		double discountRate = totalAmount >= 5000 ? 0.1 : 0.07;
		return totalAmount - (totalAmount * discountRate);
	}
	
}
