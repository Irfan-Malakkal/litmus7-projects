package com.litmus7.rentalvehicle.ui;

import java.util.List;

import com.litmus7.rentalvehicle.controller.*;
import com.litmus7.rentalvehicle.dto.*;

/**
 * The entry point for the Rental Vehicle Management application.
 * <p>
 * This class demonstrates how to:
 * <ul>
 * <li>Load vehicles from a file</li>
 * <li>Add new vehicles manually</li>
 * <li>Search and rent a vehicle</li>
 * <li>Return a rented vehicle</li>
 * <li>Display all or available vehicles</li>
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
		VehicleController vehicleController = new VehicleController();

		// Response objects to hold results of various operations
		Response<String> loadVehicleResponse = new Response<>();
		Response<Vehicle> addVehicleResponse = new Response<>();
		Response<Vehicle> searchVehicleResponse = new Response<>();
		Response<Vehicle> rentVehicleResponse = new Response<>();
		Response<Vehicle> returnVehicleResponse = new Response<>();

		// Load vehicles from a file
		System.out.println("Loading vehicles from file...\n");
		loadVehicleResponse = vehicleController.loadVehiclesFromFile("vehicles.txt");
		if (loadVehicleResponse.getStatusCode() == 200) {
			System.out.println(loadVehicleResponse.getData());
		} else {
			System.out.println(loadVehicleResponse.getErrorMessage());
		}

		// Add a new vehicle (Car) manually
		addVehicleResponse = vehicleController.addCar("Tesla", "Model 3", 80.0, 4, true);
		if (addVehicleResponse.getStatusCode() == 200) {
			System.out.println("\n" + addVehicleResponse.getData() + "\nAdded succesfully");
		} else {
			System.out.print(addVehicleResponse.getErrorMessage());
		}

		// Display all vehicles
		System.out.println("\n------------All loaded vehicles------------\n");
		printVehicles(vehicleController.getAllVehicles());

		// Simulate renting the newly added vehicle
		System.out.println("\n--- Renting a vehicle(Direct) ---");
		rentVehicleResponse = vehicleController.rentVehicle(addVehicleResponse.getData());
		System.out.println("Vehicle rented: " + rentVehicleResponse.getData());

		// For renting another vehicle
		System.out.println("\n--- Renting a vehicle(Search) ---");
		String brand = "Toyota";
		String model = "Corolla";
		System.out.println("Brand : " + brand + "\nModel : " + model);

		// Search and rent the specified vehicle
		searchVehicleResponse = vehicleController.searchVehicle(brand, model);
		if (searchVehicleResponse.getStatusCode() == 200) {
			rentVehicleResponse = vehicleController.rentVehicle(searchVehicleResponse.getData());
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
		printVehicles(vehicleController.getAvailableVehicles());

		// Return previously rented vehicle
		System.out.println("\n--- Returning the vehicle ---");
		returnVehicleResponse = vehicleController.returnVehicle(addVehicleResponse.getData());
		if (returnVehicleResponse.getStatusCode() == 200) {
			System.out.println("Vehicle Returned: " + returnVehicleResponse.getData());
		} else {
			System.out.println(returnVehicleResponse.getErrorMessage());
		}

		// Display available vehicles after returning
		System.out.println("\n--- Available Vehicles After Returning ---");
		printVehicles(vehicleController.getAvailableVehicles());

	}
}
