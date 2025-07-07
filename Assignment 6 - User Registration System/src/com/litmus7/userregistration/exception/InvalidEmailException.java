package com.litmus7.userregistration.exception;

/**
 * Exception thrown when a user's email is considered invalid during
 * registration or update.
 */
public class InvalidEmailException extends Exception {
	/**
	 * Constructs a new {@code InvalidEmailException} with the specified detail
	 * message.
	 * 
	 * @param errorMessage the detail message explaining why the email is invalid
	 */
	public InvalidEmailException(String errorMessage) {
		super(errorMessage);
	}
}
