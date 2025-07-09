package com.litmus7.userregistration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.DBConnectionException;
import com.litmus7.userregistration.exception.UserDataAccessException;
import com.litmus7.userregistration.util.DBConnection;
import com.litmus7.userregistration.constant.SQLConstants;

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
	public User saveUser(User user) throws UserDataAccessException {
		try (Connection connnection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connnection.prepareStatement(SQLConstants.INSERT_USER,
						PreparedStatement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());

			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows == 0) {
				throw new UserDataAccessException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					user.setId(generatedKeys.getInt(1));
				} else {
					throw new UserDataAccessException("Creating user failed, no ID obtained.");
				}
			}
			return user;

		} catch (DBConnectionException e) {
			throw new UserDataAccessException(e.getMessage(), e);
		} catch (SQLException e) {
			throw new UserDataAccessException("Error occured while saving user to database", e);
		}
	}

	/**
	 * Get the {@link User} object given the username.
	 * 
	 * <p>
	 * This method establishes a connection using {@link DBConnection}, prepares an
	 * SQL SELECT statement, and executes it.
	 * </p>
	 * 
	 * @param username the username being used to get the user
	 * @return {@link User} or null
	 * @throws UserDataAccessException if connection fails or query fails
	 */
	public User getUserByUsername(String username) throws UserDataAccessException {
		try (Connection connnection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connnection.prepareStatement(SQLConstants.GET_USER_BY_USERNAME)) {

			preparedStatement.setString(1, username);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return new User(resultSet.getString(SQLConstants.USERNAME), resultSet.getInt(SQLConstants.AGE),
							resultSet.getString(SQLConstants.EMAIL), resultSet.getString(SQLConstants.PASSWORD));
				}
				return null;
			}

		} catch (DBConnectionException e) {
			throw new UserDataAccessException(e.getMessage(), e);
		} catch (SQLException e) {
			throw new UserDataAccessException("Error while getting user from database", e);
		}
	}
}
