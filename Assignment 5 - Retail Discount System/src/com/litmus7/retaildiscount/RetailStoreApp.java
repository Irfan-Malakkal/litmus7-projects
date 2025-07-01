package com.litmus7.retaildiscount;

import java.util.Scanner;
import com.litmus7.retaildiscount.dto.*;

public class RetailStoreApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Customer Type (1-Regular, 2-Premium, 3-Wholesale) :");
		int customerType = scanner.nextInt();
		System.out.println("Enter Total Purchase Amount");
		double totalAmount = scanner.nextDouble();
		
		Discountable customer = null;
		switch(customerType) {
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
				System.out.println("Enter a valid customer type.");
				break;
		}
		
		double finalAmount = customer.applyDiscount(totalAmount);
		double discountApplied = totalAmount - finalAmount;
		
		System.out.println("Original Amount = "+ totalAmount + "\nDiscount Applied = " + discountApplied + "\nFinal Amount = " + finalAmount);
			
	}

}
