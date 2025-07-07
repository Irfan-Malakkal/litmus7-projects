package com.litmus7.userregistration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.DBConnectionException;
import com.litmus7.userregistration.exception.UserDataAccessException;
import com.litmus7.userregistration.util.DBConnection;

/**
 * Data Access Object (DAO) class responsible for performing database operations
 * related to the {@link User} entity.
 * 
 * <p>
 * It uses JDBC to interact with the database and handles exceptions by throwing
 * {@link UserDataAccessException} for service layer.
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class UserDAO {

	/**
	 * Saves the given {@link User} object into the database.
	 * 
	 * <p>
	 * This method establishes a connection using {@link DBConnection}, prepares an
	 * SQL INSERT statement, and executes it.
	 * </p>
	 *
	 * @param user the {@link User} object containing user data
	 * @throws UserDataAccessException if a database connection cannot be
	 *                                 established or if an error occurs while
	 *                                 executing the SQL operation
	 */
	public void saveUser(User user) throws UserDataAccessException {
		try (Connection connnection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connnection
						.prepareStatement("INSERT INTO users (username, age, email, password) VALUES (?, ?, ?, ?)")) {

			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());

			preparedStatement.executeUpdate();

		} catch (DBConnectionException e) {
			throw new UserDataAccessException(e.getMessage(), e);
		} catch (SQLException e) {
			throw new UserDataAccessException("Error while saving user to database", e);
		}
	}
}
