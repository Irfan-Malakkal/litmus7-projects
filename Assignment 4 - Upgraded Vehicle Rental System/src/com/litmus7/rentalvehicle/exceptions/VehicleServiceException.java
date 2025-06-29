package com.litmus7.rentalvehicle.exceptions;

/**
 * Exception thrown when a service-level error occurs in the vehicle rental application.
 * 
 * @author Muhammed Irfan
 */
public class VehicleServiceException extends Exception {

	/**
     * Constructs a new {@code VehicleServiceException} with the specified detail message.
     *
     * @param errorMessage the detail message explaining the reason for the exception
     */
	public VehicleServiceException(String errorMessage) {
		super(errorMessage);
	}

	/**
     * Constructs a new {@code VehicleServiceException} with the specified detail message and cause.
     *
     * @param errorMessage the detail message explaining the reason for the exception
     * @param cause the cause of the exception (a {@link Throwable} object)
     */
	public VehicleServiceException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}

}
