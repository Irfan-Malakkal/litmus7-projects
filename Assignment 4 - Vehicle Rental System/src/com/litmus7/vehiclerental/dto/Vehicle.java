package com.litmus7.vehiclerental.dto;

import java.util.Scanner;



/**
 * Represents a vehicle available for rent.
 * <p>
 * This class contains basic vehicle details such as brand, model, and rental price per day.
 * It provides methods to input and display this information via the console.
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class Vehicle {
	
	// Instance variables to store vehicle details
	private String brand;
	private String model;
	private double rentalPricePerDay;
	
	/**
     * Default constructor.
     * Initializes the vehicle with default values.
     */
	public Vehicle() {
		brand = "Unknown";
		model = "Unknown";
		rentalPricePerDay = 0.0; 
	}
	/**
     * Parameterized constructor.
     * Initializes the vehicle with provided brand, model, and rental price per day.
     * 
     * @param brand The brand of the vehicle
     * @param model The model of the vehicle
     * @param rentalPricePerDay The rental price per day for the vehicle
     */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}
	
	/**
     * Prompts the user to input vehicle details via the console.
     * Uses Scanner to read input from the user.
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
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Rental Price/Day: " + rentalPricePerDay);
	}
}
