package com.litmus7.rentalvehicle.exceptions;


/**
 * Exception thrown when attempting to add a vehicle that already exists in the system.
 * <p>
 * This helps prevent duplicate entries based on brand and model in the vehicle list.
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class DuplicateVehicleException extends Exception {
		/**
	     * Constructs a new {@code DuplicateVehicleException} with the specified detail message.
	     *
	     * @param errorMessage the detail message explaining the reason for the exception
	     */
		public DuplicateVehicleException(String errorMessage) {
			super(errorMessage);
		}
}
