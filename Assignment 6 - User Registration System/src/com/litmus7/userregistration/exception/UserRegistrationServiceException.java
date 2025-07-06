package com.litmus7.userregistration.exception;

public class UserRegistrationServiceException extends Exception{
	
	public UserRegistrationServiceException(String errorMessage) {
		super(errorMessage);
	}
	
	public UserRegistrationServiceException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
