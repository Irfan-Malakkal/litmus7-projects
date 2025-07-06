package com.litmus7.userregistration.service;

import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.*;

public class UserRegistration {

	public User registerUser(String username, int age, String email, String password)
			throws UserRegistrationServiceException {

		try {
			if (username.trim().isEmpty()) {
				throw new IllegalArgumentException("Username cannot be empty");
			}
			if (age < 18 || age > 60) {
				throw new InvalidAgeException("Age must be between 18 and 60.");
			}
			if (!email.contains("@") || !email.contains(".")) {
				throw new InvalidEmailException("Invalid email format. Must contain '@' and '.'.");
			}
			if (password.length() < 6) {
				throw new WeakPasswordException("Password too weak. Must be at least 6 characters.");
			}
		} catch (IllegalArgumentException | InvalidAgeException | InvalidEmailException | WeakPasswordException e) {
			throw new UserRegistrationServiceException(e.getMessage(), e);
		}

		return new User(username, age, email, password);
	}
}
