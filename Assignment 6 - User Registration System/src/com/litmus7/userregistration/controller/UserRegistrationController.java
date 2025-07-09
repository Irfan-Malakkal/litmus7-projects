package com.litmus7.userregistration.controller;

import com.litmus7.userregistration.dto.Response;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.UserRegistrationServiceException;
import com.litmus7.userregistration.service.UserRegistrationService;

import static com.litmus7.userregistration.constant.ResponseConstants.*;

/**
 * Controller class responsible for handling user registration requests. It
 * validates the input data and delegates the registration process to the
 * service layer. Returns a {@link Response} object encapsulating the result or
 * error message.
 * 
 * @author Muhammed Irfan
 */
public class UserRegistrationController {

	// Service layer instance
	private UserRegistrationService userRegistrationService = new UserRegistrationService();

	/**
	 * Registers a user based on the provided input parameters. Validates input
	 * before invoking the service layer.
	 *
	 * @param username the user's username
	 * @param age      the user's age
	 * @param email    the user's email address
	 * @param password the user's password
	 * @return {@link Response} containing the registered {@link User} object on
	 *         success, or an error message with appropriate status code on failure
	 */
	public Response<User> registerUser(String username, int age, String email, String password) {
		Response<User> response = new Response<>();
		if (username == null || email == null || password == null) {
			response.setErrorMessage("Invalid value for parameters");
			response.setStatusCode(ERROR_CODE);
		} else {
			try {
				response.setData(userRegistrationService.registerUser(username, age, email, password));
				response.setStatusCode(SUCCESS_CODE);
			} catch (UserRegistrationServiceException e) {
				response.setErrorMessage(e.getMessage());
				response.setStatusCode(ERROR_CODE);
			}
		}
		return response;
	}
}
