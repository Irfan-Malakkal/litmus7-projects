package com.litmus7.userregistration.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.litmus7.userregistration.exception.DBConnectionException;
import com.litmus7.userregistration.constant.DBConstants;

import java.io.IOException;
import java.io.InputStream;

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

	private static String url;
	private static String username;
	private static String password;

	/**
	 * Static initializer block to load database configuration from a properties
	 * file.
	 * 
	 * <p>
	 * This block reads the database connection details such as URL, username, and
	 * password from a properties file at class load time. The file is loaded using
	 * the class loader, and its values are assigned to static fields.
	 * </p>
	 * 
	 * <p>
	 * If the properties file is not found or fails to load, a
	 * {@link RuntimeException} is thrown to prevent the application from running
	 * with invalid or missing DB config.
	 * </p>
	 */
	static {
		try (InputStream input = DBConnection.class.getClassLoader()
				.getResourceAsStream(DBConstants.DB_PROPERTIES_FILE)) {
			Properties props = new Properties();
			if (input == null) {
				throw new RuntimeException("Unable to find properties file");
			}
			props.load(input);
			url = props.getProperty(DBConstants.DB_URL_KEY);
			username = props.getProperty(DBConstants.DB_USERNAME_KEY);
			password = props.getProperty(DBConstants.DB_PASSWORD_KEY);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load DB configuration", e);
		}
	}

	/**
	 * Establishes and returns a connection to the database.
	 * 
	 * 
	 * @return a valid {@link Connection} to the database
	 * @throws DBConnectionException if the connection cannot be established
	 */
	public static Connection getConnection() throws DBConnectionException {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			throw new DBConnectionException("Couldn't connect to Database", e);
		}
	}
}
