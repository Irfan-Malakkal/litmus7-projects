package com.litmus7.retailproductcatalog.app;

import java.util.List;
import java.util.Scanner;

import com.litmus7.retailproductcatalog.controller.RetailProductController;
import com.litmus7.retailproductcatalog.dto.Product;
import com.litmus7.retailproductcatalog.dto.Response;

import static com.litmus7.retailproductcatalog.constant.ResponseConstants.*;

/**
 * Entry point for the Retail Product Catalog application.
 * 
 * <p>This class provides a command-line interface (CLI) for users
 * to perform CRUD operations on {@link Product} objects, including:
 * adding, viewing, updating, and deleting products.
 * 
 * <p>The class interacts with the {@link RetailProductController}
 * to delegate business logic and receives {@link Response} objects
 * to display user-friendly messages.
 * 
 * <p>All user input is handled using a {@link Scanner}.
 * 
 * @author Muhammed Irfan
 */
public class ProductApp {

	private static final Scanner scanner = new Scanner(System.in);
	private static final RetailProductController retailProductController = new RetailProductController();


    /**
     * Main method that displays a menu and handles user interaction.
     *
     * @param args command-line arguments (not used)
     */
	public static void main(String[] args) {

		int choice;
		do {
			System.out.println("===========MENU===========\n"
					+ "1.Add Product\n2.View Product by ID\n3.View All Products\n4.Update Product\n5.Delete Product\n6.Exit\n"
					+ "==========================");
			System.out.print("Choose an Option : ");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				addProduct();
				break;
			case 2:
				viewProductById();
				break;
			case 3:
				viewAllProducts();
				break;
			case 4:
				updateProduct();
				break;
			case 5:
				deleteProduct();
				break;
			case 6:
				System.out.println("Thank you for using RetailMart Product Catalog Manager. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
			}
		} while (choice != 6);
		
		scanner.close();
	}


    /**
     * Handles logic for adding a new product by collecting user input.
     */
	private static void addProduct() {
		Response<Product> response = new Response<>();

		System.out.print("Enter Product ID: ");
		int id = Integer.parseInt(scanner.nextLine());

		System.out.print("Enter Name: ");
		String name = scanner.nextLine();

		System.out.print("Enter Category: ");
		String category = scanner.nextLine();

		System.out.print("Enter Price: ");
		double price = Double.parseDouble(scanner.nextLine());

		System.out.print("Enter Stock Quantity: ");
		int quantity = Integer.parseInt(scanner.nextLine());

		Product product = new Product(id, name, category, price, quantity);
		response = retailProductController.addProduct(product);

		if (response.getStatusCode() == SUCCESS_CODE) {
			System.out.println("Product added successfully.");
			System.out.println(response.getData());
		} else {
			System.out.println(response.getErrorMessage());
		}
	}

    /**
     * Displays product details by product ID.
     */
	private static void viewProductById() {
		Response<Product> response = new Response<>();
		System.out.print("Enter Product ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		response = retailProductController.getProductById(id);

		if (response.getStatusCode() == SUCCESS_CODE) {
			System.out.println("Product Details: " + response.getData());
		} else {
			System.out.println(response.getErrorMessage());
		}
	}

    /**
     * Displays all available products.
     */
	private static void viewAllProducts() {
		Response<List<Product>> response = new Response<>();
		response = retailProductController.getAllProducts();
		if (response.getStatusCode() == SUCCESS_CODE) {
			System.out.println("All Products:");
			response.getData().forEach(System.out::println);
		} else {
			System.out.println(response.getErrorMessage());
		}
	}

    /**
     * Updates product information based on user input.
     */
	private static void updateProduct() {
		Response<Product> existingProductResponse = new Response<>();
		Response<Product> updatedProductResponse = new Response<>();
		System.out.print("Enter Product ID to update: ");
		int id = Integer.parseInt(scanner.nextLine());

		existingProductResponse = retailProductController.getProductById(id);

		if (existingProductResponse.getStatusCode() == SUCCESS_CODE) {
			System.out.print("Enter new Name [" + existingProductResponse.getData().getName() + "]: ");
			String name = scanner.nextLine();
			existingProductResponse.getData().setName(name);

			System.out.print("Enter new Category [" + existingProductResponse.getData().getCategory() + "]: ");
			String category = scanner.nextLine();
			existingProductResponse.getData().setCategory(category);

			System.out.print("Enter new Price [" + existingProductResponse.getData().getPrice() + "]: ");
			String priceStr = scanner.nextLine();
			existingProductResponse.getData().setPrice(Double.parseDouble(priceStr));

			System.out
					.print("Enter new Stock Quantity [" + existingProductResponse.getData().getStockQuantity() + "]: ");
			String qtyStr = scanner.nextLine();
			existingProductResponse.getData().setStockQuantity(Integer.parseInt(qtyStr));

			updatedProductResponse = retailProductController.updateProduct(existingProductResponse.getData());

			if (updatedProductResponse.getStatusCode() == SUCCESS_CODE) {
				System.out.println("Product updated successfully.");
				System.out.println(updatedProductResponse.getData());
			} else {
				System.out.println(updatedProductResponse.getErrorMessage());
			}
		} else {
			System.out.println(existingProductResponse.getErrorMessage());
		}

	}

    /**
     * Deletes a product by ID based on user input.
     */
	private static void deleteProduct() {
		Response<Integer> response = new Response<>();
		System.out.print("Enter Product ID to delete: ");
		int id = Integer.parseInt(scanner.nextLine());

		response = retailProductController.deleteProductById(id);
		if (response.getStatusCode() == SUCCESS_CODE) {
			System.out.println("Product ID: " + response.getData() + " Deleted Succesfully");
		} else {
			System.out.println(response.getErrorMessage());
		}

	}

}
