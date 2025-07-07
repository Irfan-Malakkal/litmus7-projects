package com.litmus7.userregistration.exception;

/**
 * Exception thrown when a user's age is invalid during registration or update.
 */
public class InvalidAgeException extends Exception {

	/**
	 * Constructs a new {@code InvalidAgeException} with the specified error
	 * message.
	 * 
	 * @param errrMessage the detail message explaining why the age is invalid
	 */
	public InvalidAgeException(String errrMessage) {
		super(errrMessage);
	}
}
