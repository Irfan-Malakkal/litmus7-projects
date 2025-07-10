package com.litmus7.retailproductcatalog.exception;

public class RetailProductServiceException extends Exception {
	/**
	 * Constructs a new {@code RetailProductServiceException} with the specified
	 * detail message.
	 * 
	 * @param errorMessage the detail message explaining the service error
	 */
	public RetailProductServiceException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * Constructs a new {@code RetailProductServiceException} with the specified
	 * detail message and cause.
	 * 
	 * @param errorMessage the detail message explaining the service error
	 * @param cause        the underlying cause of the exception
	 */
	public RetailProductServiceException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
