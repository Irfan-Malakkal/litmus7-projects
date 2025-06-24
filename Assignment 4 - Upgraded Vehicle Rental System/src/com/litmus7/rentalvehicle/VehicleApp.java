package com.litmus7.rentalvehicle;

import com.litmus7.rentalvehicle.service.*;
import com.litmus7.rentalvehicle.dto.*;

/**
 * The entry point for the Rental Vehicle Management application.
 * <p>
 * This class demonstrates loading vehicles from a file, adding new vehicles,
 * renting and returning vehicles, and displaying vehicle details using the
 * {@link VehicleService}.
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class VehicleApp {

	/**
     * Main method to run the application.
     * 
     * @param args command-line arguments (not used)
     */
	public static void main(String[] args) {
		
		// Create a VehicleService to manage vehicles
		VehicleService service = new VehicleService();

		// Load vehicles from a file
        System.out.println("Loading vehicles from file...");
        service.loadVehiclesFromFile("src/vehicles.txt");

        // Add a new vehicle manually
        Car newCar = new Car("Tesla", "Model 3", 80.0, 4, true);
        service.addVehicle(newCar);

        // Display all available vehicles
        System.out.println("\n------------All loaded vehicles------------\n");
        service.displayAvailableVehicles();
        
        // Simulate renting a vehicle
        System.out.println("\n--- Renting a vehicle ---");
        Vehicle toyota = service.searchVehicles("Toyota","Corolla");        
        service.rentVehicle(toyota);
        Vehicle yamaha = service.searchVehicles("Yamaha","R15");
        service.rentVehicle(yamaha);
        
        // Display available vehicles after renting
        System.out.println("\n--- Available Vehicles After Renting ---");
        service.displayAvailableVehicles();

        // Simulate returning a vehicle
        System.out.println("\n--- Returning the vehicle ---");
        service.returnVehicle(yamaha);

        // Display available vehicles after returning
        System.out.println("\n--- Available Vehicles After Returning ---");
        service.displayAvailableVehicles();


	}

}
