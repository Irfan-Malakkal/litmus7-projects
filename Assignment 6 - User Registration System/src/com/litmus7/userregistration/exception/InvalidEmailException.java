package com.litmus7.userregistration.exception;

public class InvalidEmailException extends Exception {
	public InvalidEmailException(String errorMessage) {
        super(errorMessage);
    }
}
