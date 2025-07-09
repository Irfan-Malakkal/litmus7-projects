package com.litmus7.userregistration.constant;

/**
 * Defines constants related to database configuration properties.
 * 
 * <p>
 * This class contains keys and file names used to access database connection
 * information from a properties file.
 * </p>
 */
public class DBConstants {
    /**
     * The name of the properties file that contains database configuration.
     */
	public static final String DB_PROPERTIES_FILE = "userdb.properties";
    /**
     * The key used to retrieve the database URL from the properties file.
     */
	public static final String DB_URL_KEY = "dburl";
    /**
     * The key used to retrieve the database username from the properties file.
     */
	public static final String DB_USERNAME_KEY = "username";
    /**
     * The key used to retrieve the database password from the properties file.
     */
	public static final String DB_PASSWORD_KEY = "password";
}
