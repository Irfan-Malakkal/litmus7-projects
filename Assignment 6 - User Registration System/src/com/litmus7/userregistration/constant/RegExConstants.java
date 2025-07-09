package com.litmus7.userregistration.constant;

import java.util.regex.Pattern;

/**
 * Defines regular expression patterns used for validating user input fields.
 * 
 * <p>
 * This class contains precompiled {@link Pattern} objects.
 * </p>
 */
public class RegExConstants {

	/**
	 * Regular expression pattern for validating email addresses.
	 */
	public static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
}
