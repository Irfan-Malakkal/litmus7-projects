package com.litmus7.userregistration.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.litmus7.userregistration.exception.DBConnectionException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Utility class responsible for establishing database connections.
 * 
 * <p>
 * This class reads database configuration properties from the
 * {@code userdb.properties} file and creates a {@link Connection} using
 * {@link DriverManager}.
 * </p>
 * 
 * <p>
 * If the properties file is missing, unreadable, or the connection attempt
 * fails, it throws a {@link DBConnectionException}.
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class DBConnection {

	/**
	 * Establishes and returns a connection to the database.
	 * 
	 * <p>
	 * Reads database connection properties from {@code userdb.properties} file,
	 * including URL, username, and password.
	 * </p>
	 * 
	 * @return a valid {@link Connection} to the database
	 * @throws DBConnectionException if the properties file cannot be loaded or the
	 *                               connection cannot be established
	 */
	public static Connection getConnection() throws DBConnectionException {
		Properties properties = new Properties();
		try (FileInputStream fileInput = new FileInputStream("userdb.properties");) {
			properties.load(fileInput);

			String url = properties.getProperty("dburl");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			return DriverManager.getConnection(url, username, password);

		} catch (FileNotFoundException e) {
			throw new DBConnectionException("Couldn't load file", e);
		} catch (IOException e) {
			throw new DBConnectionException("Couldn't load file", e);
		} catch (SQLException e) {
			throw new DBConnectionException("Couldn't connect to Database", e);
		}
	}
}
