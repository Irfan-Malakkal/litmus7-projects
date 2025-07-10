package com.litmus7.retailproductcatalog.exception;

/**
 * Exception thrown when there is an error establishing a database connection.
 */
public class DBConnectionException extends Exception {
	/**
	 * Constructs a new {@code DBConnectionException} with the specified error
	 * message.
	 * 
	 * @param errorMessage the detail message explaining the connection failure
	 */
	public DBConnectionException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * Constructs a new {@code DBConnectionException} with the specified error
	 * message and cause.
	 * 
	 * @param errorMessage the detail message explaining the connection failure
	 * @param cause        the underlying cause of the exception
	 */
	public DBConnectionException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
