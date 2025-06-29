package com.litmus7.rentalvehicle.ui;

import java.util.List;
import java.util.Scanner;

import com.litmus7.rentalvehicle.controller.*;
import com.litmus7.rentalvehicle.dto.*;

/**
 * The entry point for the Rental Vehicle Management application.
 * <p>
 * This class demonstrates how to:
 * <ul>
 *   <li>Load vehicles from a file</li>
 *   <li>Add new vehicles manually</li>
 *   <li>Search and rent a vehicle</li>
 *   <li>Return a rented vehicle</li>
 *   <li>Display all or available vehicles</li>
 * </ul>
 * All operations are performed using {@link VehicleController}.
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class VehicleApp {

	 /**
     * Prints a formatted list of vehicles or an error message if the response
     * indicates a failure.
     *
     * @param response the response object
     */
	private static void printVehicles(Response<List<Vehicle>> response) {

		if (response.getStatusCode() == 200) {
			System.out.println("-----------------------------------------------------------------------");
			System.out.printf("%-10s %-10s %-11s %-12s %-12s\n", "Brand", "Model", "Price/Day", "Doors/CC", "Gear");
			System.out.println("-----------------------------------------------------------------------");
			for (Vehicle v : response.getData()) {
				System.out.println(v);
			}
			System.out.println("-----------------------------------------------------------------------");
		} else {
			System.out.print(response.getErrorMessage());
		}
		System.out.println();

	}

	/**
	 * Main method to run the application.
	 * 
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {

		// Instantiate the controller
		VehicleController controller = new VehicleController();


        // Response objects to hold results of various operations
		Response<List<Vehicle>> loadVehicleResponse = new Response<>();
		Response<Vehicle> addVehicleResponse = new Response<>();
		Response<Vehicle> searchVehicleResponse = new Response<>();
		Response<Vehicle> rentVehicleResponse = new Response<>();
		Response<Vehicle> returnVehicleResponse = new Response<>();

		// Load vehicles from a file
		System.out.println("Loading vehicles from file...\n");
		loadVehicleResponse = controller.loadVehiclesFromFile("vehicles.txt");
		if (loadVehicleResponse.getStatusCode() == 200) {
			System.out.println("Vehicles Loaded Successfully");
		} else {
			System.out.println(loadVehicleResponse.getErrorMessage());
		}

		// Add a new vehicle (Car) manually
		addVehicleResponse = controller.addCar("Tesla", "Model 3", 80.0, 4, true);
		if (addVehicleResponse.getStatusCode() == 200) {
			System.out.println("\n" + addVehicleResponse.getData() + "\nAdded succesfully");
		} else {
			System.out.print(addVehicleResponse.getErrorMessage());
		}

		// Display all vehicles
		System.out.println("\n------------All loaded vehicles------------\n");
		printVehicles(controller.getAllVehicles());

		// Simulate renting the newly added vehicle
		System.out.println("\n--- Renting a vehicle(Direct) ---");
		rentVehicleResponse = controller.rentVehicle(addVehicleResponse.getData());
		System.out.println("Vehicle rented: " + rentVehicleResponse.getData());

		// User input for renting another vehicle
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n--- Renting a vehicle(User Input) ---");
		System.out.println("Enter Brand: ");
		String brand = scanner.nextLine();
		System.out.println("Enter String: ");
		String model = scanner.nextLine();

		// Search and rent the specified vehicle
		searchVehicleResponse = controller.searchVehicle(brand, model);
		if (searchVehicleResponse.getStatusCode() == 200) {
			rentVehicleResponse = controller.rentVehicle(searchVehicleResponse.getData());
			if (rentVehicleResponse.getStatusCode() == 200) {
				System.out.println("Vehicle rented: " + rentVehicleResponse.getData());
			} else {
				System.out.println(rentVehicleResponse.getErrorMessage());
			}
		} else {
			System.out.println(searchVehicleResponse.getErrorMessage());
		}

		// Display available vehicles after renting
		System.out.println("\n--- Available Vehicles After Renting ---");
		printVehicles(controller.getAvailableVehicles());

		// Return previously rented vehicle
		System.out.println("\n--- Returning the vehicle ---");
		returnVehicleResponse = controller.returnVehicle(addVehicleResponse.getData());
		if (returnVehicleResponse.getStatusCode() == 200) {
			System.out.println("Vehicle Returned: " + returnVehicleResponse.getData());
		} else {
			System.out.println(returnVehicleResponse.getErrorMessage());
		}
		
		// Display available vehicles after returning
		System.out.println("\n--- Available Vehicles After Returning ---");
		printVehicles(controller.getAvailableVehicles());
		
		scanner.close();

	}

}
