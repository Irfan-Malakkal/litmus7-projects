package com.litmus7.userregistration.exception;

/**
 * Exception thrown when an error occurs within the user registration service
 * layer.
 */
public class UserRegistrationServiceException extends Exception {
	/**
	 * Constructs a new {@code UserRegistrationServiceException} with the specified
	 * detail message.
	 * 
	 * @param errorMessage the detail message explaining the service error
	 */
	public UserRegistrationServiceException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * Constructs a new {@code UserRegistrationServiceException} with the specified
	 * detail message and cause.
	 * 
	 * @param errorMessage the detail message explaining the service error
	 * @param cause        the underlying cause of the exception
	 */
	public UserRegistrationServiceException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
