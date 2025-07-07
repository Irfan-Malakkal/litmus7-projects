package com.litmus7.userregistration.exception;

/**
 * Exception thrown when an error occurs while accessing or manipulating user
 * data in the database.
 */
public class UserDataAccessException extends Exception {
	/**
	 * Constructs a new {@code UserDataAccessException} with the specified detail
	 * message.
	 * 
	 * @param errorMessage the detail message explaining the data access failure
	 */
	public UserDataAccessException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * Constructs a new {@code UserDataAccessException} with the specified detail
	 * message and cause.
	 * 
	 * @param errorMessage the detail message explaining the data access failure
	 * @param cause        the underlying cause of the exception
	 */
	public UserDataAccessException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
