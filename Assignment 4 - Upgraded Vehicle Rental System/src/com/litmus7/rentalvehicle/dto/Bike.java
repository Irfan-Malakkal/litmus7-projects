package com.litmus7.rentalvehicle.dto;

import java.util.Scanner;

/**
 * Represents a bike that can be rented.
 * <p>
 * Inherits common vehicle properties from the {@link Vehicle} class and adds
 * bike-specific attributes such as gear presence and engine capacity.
 * </p>
 * 
 * Provides methods to input and display bike-specific information along with
 * the general vehicle details.
 * 
 * @author Muhammed Irfan
 */
public class Bike extends Vehicle {

	private boolean hasGear;
	private int engineCapacity;

	/**
	 * Default constructor. Initializes the bike with default values.
	 */
	public Bike() {
		super();
		hasGear = false;
		engineCapacity = 0;
	}

	/**
	 * Parameterized constructor. Initializes the bike with provided values,
	 * including brand, model, rental price, gear availability, and engine capacity.
	 * 
	 * @param brand             the brand of the bike
	 * @param model             the model of the bike
	 * @param rentalPricePerDay the rental price per day for the bike
	 * @param hasGear           whether the bike has gears
	 * @param engineCapacity    the engine capacity of the bike in cc
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Prompts the user to input bike details via the console.
	 * <p>
	 * Collects input for inherited vehicle attributes and bike-specific fields such
	 * as gear status and engine capacity.
	 * </p>
	 */
	@Override
	public void inputDetails() {
		super.inputDetails();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Does it have gears (true/false)?");
		hasGear = scanner.nextBoolean();
		System.out.println("Enter engine capacity (cc):");
		engineCapacity = scanner.nextInt();
	}

	/**
	 * Displays the bike details, including inherited vehicle attributes and
	 * bike-specific information such as gear availability and engine capacity.
	 */
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.printf("%d %-6s %-12s %s\n", engineCapacity, "cc", "hasGear:", hasGear);
	}

}
