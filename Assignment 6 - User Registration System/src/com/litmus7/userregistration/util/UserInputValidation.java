package com.litmus7.userregistration.util;

import com.litmus7.userregistration.constant.RegExConstants;
import com.litmus7.userregistration.constant.ValidationConstants;

/**
 * Utility class providing validation methods for user input fields such as
 * username, age, email, and password.
 * 
 * <p>
 * This class includes static methods to validate user inputs based on
 * predefined constants and regular expressions.
 * </p>
 */
public class UserInputValidation {
	/**
	 * Validates the given username.
	 *
	 * @param username the username to validate
	 * @return {@code true} if the username is not {@code null} and not empty after
	 *         trimming; {@code false} otherwise
	 */
	public static boolean isValdUsername(String username) {
		return username != null && !username.trim().isEmpty();
	}

	/**
	 * Validates the given age against the minimum and maximum allowed age.
	 *
	 * @param age the age to validate
	 * @return {@code true} if the age is within the allowed range defined in
	 *         {@link ValidationConstants}; {@code false} otherwise
	 */
	public static boolean isValidAge(int age) {
		return age >= ValidationConstants.MIN_AGE && age <= ValidationConstants.MAX_AGE;
	}

	/**
	 * Validates the given email address using a regular expression pattern.
	 *
	 * @param email the email to validate
	 * @return {@code true} if the email is not {@code null} and matches the
	 *         {@link RegExConstants#EMAIL_PATTERN}; {@code false} otherwise
	 */
	public static boolean isValidEmail(String email) {
		return email != null && RegExConstants.EMAIL_PATTERN.matcher(email).matches();
	}

	/**
	 * Validates the given password based on its length.
	 *
	 * @param password the password to validate
	 * @return {@code true} if the password is not {@code null} and its length is
	 *         greater than or equal to
	 *         {@link ValidationConstants#MIN_PASSWORD_LENGTH}; {@code false}
	 *         otherwise
	 */
	public static boolean isValidPassword(String password) {
		return password != null && password.length() >= ValidationConstants.MIN_PASSWORD_LENGTH;
	}
}
