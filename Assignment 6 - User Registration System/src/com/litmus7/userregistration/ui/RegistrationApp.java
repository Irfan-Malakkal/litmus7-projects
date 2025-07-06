package com.litmus7.userregistration.ui;

import java.util.Scanner;

import com.litmus7.userregistration.controller.UserRegistrationController;
import com.litmus7.userregistration.dto.Response;
import com.litmus7.userregistration.dto.User;

public class RegistrationApp {

	public static void main(String[] args) {

		UserRegistrationController userRegistrationController = new UserRegistrationController();
		Response<User> registrationResponse = new Response<>();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter username: ");
		String username = scanner.nextLine();

		System.out.print("Enter age: ");
		int age = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter email: ");
		String email = scanner.nextLine();

		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		registrationResponse = userRegistrationController.registerUser(username, age, email, password);
		if (registrationResponse.getStatusCode() == 200) {
			System.out.println(registrationResponse.getData());
		} else {
			System.out.println(registrationResponse.getErrorMessage());
		}

		scanner.close();
	}

}
