package com.litmus7.retaildiscount;

import java.util.Scanner;

import com.litmus7.retaildiscount.controller.RetailStoreController;
import com.litmus7.retaildiscount.dto.Response;

/**
 * Main class to run the Retail Store Discount application.
 * <p>
 * It collects input from the user and displays the discount and final amount.
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class RetailStoreApp {

	/**
     * Entry point of the application.
     *
     * @param args command-line arguments (not used)
     */
	public static void main(String[] args) {

		// Initialize controller
		RetailStoreController controller = new RetailStoreController();

		// Scanner to read input from the console
		Scanner scanner = new Scanner(System.in);

		// Get customer type and purchase amount input from user
		System.out.print("Enter Customer Type (1-Regular, 2-Premium, 3-Wholesale) :");
		int customerType = scanner.nextInt();
		System.out.println("Enter Total Purchase Amount");
		double totalAmount = scanner.nextDouble();

		// Process the discount request
		Response<String> discountResponse = new Response<>();
		discountResponse = controller.processDiscount(customerType, totalAmount);
		if (discountResponse.getStatusCode() == 200) {
			System.out.println(discountResponse.getData());
		} else {
			System.out.println(discountResponse.getErrorMessage());
		}

		scanner.close();

	}

}
