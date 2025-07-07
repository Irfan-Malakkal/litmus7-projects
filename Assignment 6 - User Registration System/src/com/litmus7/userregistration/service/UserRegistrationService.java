package com.litmus7.userregistration.service;

import com.litmus7.userregistration.dao.UserDAO;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.*;

/**
 * Service class responsible for handling business logic related to user
 * registration.
 * 
 * <p>
 * This class validates input data for new users. It throws detailed exceptions
 * for various validation failures and wraps them into
 * {@link UserRegistrationServiceException} for the controller layer.
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class UserRegistrationService {

	// DAO instance
	private UserDAO userDAO = new UserDAO();

	/**
	 * Registers a user after validating input parameters.
	 * 
	 * <p>
	 * If any validation fails, or if saving the user to the database fails, this
	 * method throws a {@link UserRegistrationServiceException} encapsulating the
	 * original cause.
	 * </p>
	 * 
	 * @param username the username for the new user
	 * @param age      the age of the new user
	 * @param email    the email of the new user
	 * @param password the password for the new user
	 * @return the registered {@link User} object on successful registration
	 * @throws UserRegistrationServiceException if validation fails or saving the
	 *                                          user to database fails
	 */
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

			User user = new User(username, age, email, password);
			userDAO.saveUser(user);
			return user;

		} catch (IllegalArgumentException | InvalidAgeException | InvalidEmailException | WeakPasswordException
				| UserDataAccessException e) {
			throw new UserRegistrationServiceException(e.getMessage(), e);
		}

	}
}
