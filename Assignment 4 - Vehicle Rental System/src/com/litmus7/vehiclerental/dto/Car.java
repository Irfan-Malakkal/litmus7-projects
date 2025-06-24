package com.litmus7.vehiclerental.dto;

import java.util.Scanner;

/**
 * Represents a car that can be rented.
 * <p>
 * Inherits common vehicle properties from the {@link Vehicle} class,
 * and adds specific attributes such as number of doors and transmission type.
 * </p>
 * Provides methods to input and display car-specific details in addition to general vehicle information.
 * 
 * @author Muhammed Irfan
 */
public class Car extends Vehicle {

	private int numberOfDoors;
	private boolean isAutomatic;
	
	/**
     * Default constructor.
     * Initializes the car with default values:
     */
	public Car() {
		super();
		numberOfDoors = 0;
		isAutomatic = false;
	}
	
	/**
     * Parameterized constructor.
     * Initializes the car with provided values, including brand, model,
     * rental price, number of doors, and transmission type.
     * 
     * @param brand the brand of the car
     * @param model the model of the car
     * @param rentalPricePerDay the rental price per day
     * @param numberOfDoors number of doors in the car
     * @param isAutomatic whether the car has automatic transmission
     */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}
	
	/**
     * Prompts the user to input car details via the console.
     * Includes input for vehicle attributes (via superclass) and car-specific fields:
     * number of doors and transmission type.
     */
    @Override
	public void inputDetails() {
		super.inputDetails();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of doors:");
		numberOfDoors = scanner.nextInt();
		System.out.println("Is it automatic (true/false)?");
		isAutomatic = scanner.nextBoolean();
	}
	/**
     * Displays the car's details, including inherited vehicle attributes
     * and additional car-specific information such as number of doors and transmission type.
     */
    @Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Number of Doors: " + numberOfDoors);
		System.out.println("Automatic: " + isAutomatic);
	}
}
