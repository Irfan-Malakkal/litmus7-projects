package com.litmus7.retaildiscount.service;

import com.litmus7.retaildiscount.dto.Discountable;
import com.litmus7.retaildiscount.dto.PremiumCustomer;
import com.litmus7.retaildiscount.dto.RegularCustomer;
import com.litmus7.retaildiscount.dto.WholesaleCustomer;
import com.litmus7.retaildiscount.exceptions.RetailServiceException;

/**
 * Service class responsible for applying logic.
 * Provides method to apply discount.
 *
 * @author Muhammed Irfan
 */
public class RetailStoreService {

    /**
     * Processes discount based on the customer type and total purchase amount.
     * <p>
     * Selects a discount strategy implementation based on the provided customer type,
     * calculates the final amount after discount, and returns a formatted receipt.
     * </p>
     *
     * @param customerType the type of the customer
     * @param totalAmount the total purchase amount before discount
     * @return a formatted receipt string showing original amount, discount applied, and final amount
     * @throws RetailServiceException if an invalid customer type is provided
     */
	public String processDiscount(int customerType, double totalAmount) throws RetailServiceException{
        Discountable customer;

        switch (customerType) {
            case 1:
            	customer = new RegularCustomer();
            	break;
            case 2:
				customer = new PremiumCustomer();
				break;
            case 3:
				customer = new WholesaleCustomer();
				break;
            default:
            	throw new RetailServiceException("Invalid Customer Type");
        }
        
        double finalAmount = customer.applyDiscount(totalAmount);
        double discountApplied = totalAmount - finalAmount;

        return String.format("""
                --- Receipt ---
                Original Amount  : %.2f
                Discount Applied : %.2f
                Final Amount     : %.2f
                """, totalAmount, discountApplied, finalAmount);
	}
}
