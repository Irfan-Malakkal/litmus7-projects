package com.litmus7.rentalvehicle.dto;

/**
 * A generic class to encapsulate a response.
 *
 * <p>This class is used to represent both success and error responses. It includes
 * a status code, an optional error message, and generic data.</p>
 *
 * @param <T> the type of the response
 */
public class Response<T> {
	
	//	Instance variables
	private int statusCode;
	private String errorMessage;
	private T data;

	 /**
     * Returns the status code of the response.
     *
     * @return the status code
     */
	public int getStatusCode() {
		return statusCode;
	}

	/**
     * Sets the status code of the response.
     *
     * @param statusCode the status code to set
     */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
     * Returns the error message of the response.
     *
     * @return the error message
     */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
     * Sets the error message of the response.
     *
     * @param errorMessage the error message to set
     */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
     * Returns the data of the response.
     *
     * @return the data
     */
	public T getData() {
		return data;
	}

	/**
     * Sets the data of the response.
     *
     * @param data the data to set
     */
	public void setData(T data) {
		this.data = data;
	}

}
