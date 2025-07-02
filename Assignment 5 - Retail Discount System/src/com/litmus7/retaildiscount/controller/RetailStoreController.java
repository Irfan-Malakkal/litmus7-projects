package com.litmus7.retaildiscount.controller;

import com.litmus7.retaildiscount.dto.Response;
import com.litmus7.retaildiscount.exceptions.RetailServiceException;
import com.litmus7.retaildiscount.service.*;

/**
 * Controller class to process discount requests.
 * <p>
 * This class handles basic input validation and delegates discount calculation
 * logic to the {@link RetailStoreService} class.
 * </p>
 * 
 * 
 * @author
 */
public class RetailStoreController {

	/**
	 * Status code indicating a successful operation.
	 */
	public static final int SUCCESS_CODE = 200;

	/**
	 * Status code indicating a failed operation.
	 */
	public static final int ERROR_CODE = 400;

	// Service Layer Instance
	private RetailStoreService service = new RetailStoreService();

	/**
     * Processes a discount request based on customer type and total purchase amount.
     * Validates the purchase amount before calling the service layer.
     *
     * @param customerType the type of customer (e.g., 1-Regular, 2-Premium, 3-Wholesale)
     * @param totalAmount the total purchase amount entered by the user
     * @return a {@code Response<String>} containing either the final billing details
     *         or an error message if the operation failed
     */
	public Response<String> processDiscount(int customerType, double totalAmount) {
		Response<String> response = new Response<>();
		if (totalAmount > 0) {
			try {
				response.setData(service.processDiscount(customerType, totalAmount));
				response.setStatusCode(SUCCESS_CODE);
			} catch (RetailServiceException e) {
				response.setStatusCode(ERROR_CODE);
				response.setErrorMessage(e.getMessage());
			}
		} else {
			response.setStatusCode(ERROR_CODE);
			response.setErrorMessage("Invalid Purchase Amount: Purchase amount should be greater than 0");
		}
		return response;
	}

}
