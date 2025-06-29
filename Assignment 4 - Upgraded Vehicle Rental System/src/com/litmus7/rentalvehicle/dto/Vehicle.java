package com.litmus7.rentalvehicle.dto;

import java.util.Objects;

/**
 * Represents a vehicle available for rent.
 * <p>
 * This class contains basic vehicle details such as brand, model, and rental
 * price per day.
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
     * Returns a string representation of the vehicle.
     * 
     * @return a formatted string containing the brand, model, and rental price per day
     */
	@Override
	public String toString() {
		return String.format("%-10s %-10s %-11.2f", brand, model, rentalPricePerDay);
	}

	/**
     * Returns the hash code value for this vehicle.
     * 
     * @return a hash code based on the brand and model
     */
	@Override
	public int hashCode() {
		return Objects.hash(brand, model);
	}

	/**
     * Compares this vehicle to the specified object. The result is {@code true} if
     * and only if the argument is not {@code null} and is a {@code Vehicle} object
     * that has the same brand and model as this object.
     * 
     * @param obj the object to compare this {@code Vehicle} against
     * @return {@code true} if the given object represents an equivalent vehicle,
     *         {@code false} otherwise
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(model, other.model);
	}
}
