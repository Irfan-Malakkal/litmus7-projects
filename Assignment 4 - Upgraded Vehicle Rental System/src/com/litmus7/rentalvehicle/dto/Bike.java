package com.litmus7.rentalvehicle.dto;

/**
 * Represents a bike that can be rented.
 * <p>
 * Inherits common vehicle properties from the {@link Vehicle} class and adds
 * bike-specific attributes such as gear presence and engine capacity.
 * </p>
 * 
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
	 * Displays the bike details, including inherited vehicle attributes and
	 * bike-specific information such as gear availability and engine capacity.
	 */
	@Override
	public String toString() {
		return super.toString() + String.format(" %d %-8s %-12s", engineCapacity, "cc", hasGear ? "Gear" : "No Gear");
	}

}
