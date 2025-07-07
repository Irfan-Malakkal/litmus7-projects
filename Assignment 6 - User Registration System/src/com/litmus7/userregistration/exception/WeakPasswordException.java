package com.litmus7.userregistration.exception;

/**
 * Exception thrown when a user's password does not meet the required strength
 * criteria.
 */
public class WeakPasswordException extends Exception {
	/**
	 * Constructs a new {@code WeakPasswordException} with the specified detail
	 * message.
	 *
	 * @param errorMessage the detail message explaining why the password is
	 *                     considered weak
	 */
	public WeakPasswordException(String errorMessage) {
		super(errorMessage);
	}
}
