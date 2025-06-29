package com.litmus7.rentalvehicle.dto;

/**
 * Represents a car that can be rented.
 * <p>
 * Inherits common vehicle properties from the {@link Vehicle} class, and adds
 * specific attributes such as number of doors and transmission type.
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class Car extends Vehicle {

	private int numberOfDoors;
	private boolean isAutomatic;

	/**
	 * Default constructor. Initializes the car with default values:
	 */
	public Car() {
		super();
		numberOfDoors = 0;
		isAutomatic = false;
	}

	/**
	 * Parameterized constructor. Initializes the car with provided values,
	 * including brand, model, rental price, number of doors, and transmission type.
	 * 
	 * @param brand             the brand of the car
	 * @param model             the model of the car
	 * @param rentalPricePerDay the rental price per day
	 * @param numberOfDoors     number of doors in the car
	 * @param isAutomatic       whether the car has automatic transmission
	 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 * Displays the car's details, including inherited vehicle attributes and
	 * additional car-specific information such as number of doors and transmission type.
	 */
	@Override
	public String toString() {
		return super.toString()
				+ String.format(" %d %-10s %-12s", numberOfDoors, "Doors", isAutomatic ? "Automatic" : "Manual");
	}
}
