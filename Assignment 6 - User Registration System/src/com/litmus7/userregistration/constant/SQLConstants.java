package com.litmus7.userregistration.constant;

/**
 * Defines SQL queries and column names used for user-related database
 * operations.
 *
 * <p>
 * This class centralizes all SQL statements and column name constants to
 * promote maintainability and prevent hard-coded values throughout the
 * codebase.
 * </p>
 */
public class SQLConstants {
	/**
	 * SQL query to insert a new user into the database.
	 * <p>
	 * Expects four parameters: username, age, email, and password.
	 * </p>
	 */
	public static final String INSERT_USER = "INSERT INTO users (username, age, email, password) VALUES (?, ?, ?, ?)";
	/**
	 * SQL query to retrieve a user from the database by username.
	 */
	public static final String GET_USER_BY_USERNAME = "SELECT username, age, email, password FROM users WHERE username = ?";

	/**
	 * Column name for the user ID.
	 */
	public static final String USER_ID = "id";
	/**
	 * Column name for the username.
	 */
	public static final String USERNAME = "username";
	/**
	 * Column name for the age.
	 */
	public static final String AGE = "age";
	/**
	 * Column name for the email.
	 */
	public static final String EMAIL = "email";
	/**
	 * Column name for the password.
	 */
	public static final String PASSWORD = "password";
}
