package com.litmus7.retaildiscount.dto;

/**
 * Interface representing a discount strategy for a customer type.
 * <p>
 * Implementing classes must define how the discount is applied
 * to a given purchase amount.
 * </p>
 *
 * <p>This allows different customer types (e.g., Regular, Premium, Wholesale)
 * to implement their own discount logic following the Strategy Design Pattern.</p>
 * 
 * @author Muhammed Irfan
 */
public interface Discountable {
	/**
     * Applies a discount to the provided total amount based on the customer type.
     *
     * @param totalAmount the original purchase amount
     * @return the amount after applying the discount
     */
	double applyDiscount(double totalAmount);
}
