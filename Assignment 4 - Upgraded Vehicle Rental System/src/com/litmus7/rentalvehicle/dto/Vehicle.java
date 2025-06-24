package com.litmus7.rentalvehicle.dto;

import java.util.Scanner;

/**
 * Represents a vehicle available for rent.
 * <p>
 * This class contains basic vehicle details such as brand, model, and rental
 * price per day. It provides methods to input and display this information via
 * the console.
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class Vehicle {

	// Instance variables to store vehicle details
	private String brand;
	private String model;
	private double rentalPricePerDay;
	private boolean isAvailable;

	/**
	 * Default constructor. Initializes the vehicle with default values.
	 */
	public Vehicle() {
		brand = "Unknown";
		model = "Unknown";
		rentalPricePerDay = 0.0;
		isAvailable = true;
	}

	/**
	 * Parameterized constructor. Initializes the vehicle with provided brand,
	 * model, and rental price per day.
	 * 
	 * @param brand             The brand of the vehicle
	 * @param model             The model of the vehicle
	 * @param rentalPricePerDay The rental price per day for the vehicle
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
		this.isAvailable = true;
	}

	/**
     * Returns the brand of the vehicle.
     * 
     * @return the vehicle brand
     */
	public String getBrand() {
		return brand;
	}

	/**
     * Returns the model of the vehicle.
     * 
     * @return the vehicle model
     */
	public String getModel() {
		return model;
	}

	/**
     * Returns the rental price per day of the vehicle.
     * 
     * @return the rental price per day
     */
	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}

	/**
     * Returns the availability status of the vehicle.
     * 
     * @return {@code true} if the vehicle is available, otherwise {@code false}
     */
	public boolean isAvailable() {
		return isAvailable;
	}

	 /**
     * Sets the availability status of the vehicle.
     * 
     * @param available {@code true} to mark the vehicle as available, {@code false} otherwise                  
     */
	public void setAvailable(boolean available) {
		isAvailable = available;
	}

	/**
	 * Prompts the user to input vehicle details via the console. Uses Scanner to
	 * read input from the user.
	 */
	public void inputDetails() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter brand:");
		brand = scanner.nextLine();
		System.out.println("Enter model:");
		model = scanner.nextLine();
		System.out.println("Enter rental price per day:");
		rentalPricePerDay = scanner.nextDouble();
	}

	/**
	 * Displays the vehicle details to the console.
	 */
	public void displayDetails() {
		System.out.printf("%-10s %-10s %-11.2f", getBrand(), getModel(), getRentalPricePerDay());
	}
}
