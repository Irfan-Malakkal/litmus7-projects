package com.litmus7.userregistration.exception;

public class WeakPasswordException extends Exception {
	public WeakPasswordException(String errorMessage) {
        super(errorMessage);
    }
}
