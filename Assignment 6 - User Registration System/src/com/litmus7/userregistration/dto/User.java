package com.litmus7.userregistration.dto;

/**
 * Represents a user in the system with basic personal information. This class
 * is used to transfer user data between layers such as controller, service, and
 * DAO.
 * 
 * <p>
 * It includes fields for username, age, email, and password, along with
 * appropriate getters and setters.
 * </p>
 * 
 * <p>
 * This class overrides {@code toString()} to provide a formatted display of
 * user details (excluding password for security).
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class User {

	// Instance variables
	private int id;
	private String username;
	private int age;
	private String email;
	private String password;

	/**
	 * Constructs a {@code User} with the specified values.
	 * 
	 * @param username the username of the user
	 * @param age      the age of the user
	 * @param email    the email address of the user
	 * @param password the password of the user
	 */
	public User(String username, int age, String email, String password) {
		super();
		this.username = username;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns a string representation of the user, excluding the password.
	 * 
	 * @return a formatted string with user details
	 */
	@Override
	public String toString() {
		return "-----------\nUser Details\n-----------\nId : " + id + "\nUsername : " + username + ",\nAge : " + age + ",\nEmail : "
				+ email;
	}

}
