package com.litmus7.rentalvehicle.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.rentalvehicle.dto.*;

/**
 * Service class that manages a list of vehicles for rental operations.
 * <p>
 * Provides methods to load vehicles from a file, add new vehicles, 
 * search, rent, return, and display vehicles.
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class VehicleService {
	/**
     * List that holds all vehicles available or rented.
     */
	private List<Vehicle> vehicleList = new ArrayList<>();
	
	/**
     * Loads vehicle data from a file and adds them to the vehicle list.
     * <p>
     * The file must be in a comma-separated format, with the first field indicating 
     * the vehicle type (e.g., Car or Bike).
     * </p>
     * 
     * @param filePath the path to the file containing vehicle data
     */
	public void loadVehiclesFromFile(String filePath) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				Vehicle vehicle = parseVehicle(line);
				if (vehicle != null)
					vehicleList.add(vehicle);
			}
		}
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
	
	/**
     * Parses a line from the file and creates a corresponding Vehicle object.
     * 
     * @param line the line from the file representing a vehicle
     * @return a Vehicle object (Car or Bike), or null if the type is unknown
     */
	private Vehicle parseVehicle(String line) {
		String[] parts = line.split(",");
		String type = parts[0];
		
		switch (type) {
			case "Car": 
				return new Car(
					parts[1].trim(),
	                parts[2].trim(),
	                Double.parseDouble(parts[3].trim()),
	                Integer.parseInt(parts[4].trim()),
	                Boolean.parseBoolean(parts[5].trim())
				);
			case "Bike":
				return new Bike(
					parts[1].trim(),
	                parts[2].trim(),
	                Double.parseDouble(parts[3].trim()),
	                Boolean.parseBoolean(parts[4].trim()),
	                Integer.parseInt(parts[5].trim())	
				);
			default:
				System.err.println("Unknown vehicle type: " + type);
				return null;
		}
	}
	
	/**
     * Adds a new vehicle to the list.
     * 
     * @param vehicle the Vehicle object to add
     */
	public void addVehicle(Vehicle vehicle) {
		vehicleList.add(vehicle);
	}
	
	/**
     * Searches for an available vehicle by brand and model.
     * 
     * @param brand the brand to search for
     * @param model the model to search for
     * @return the first available matching Vehicle, or null if none found
     */
    public Vehicle searchVehicles(String brand, String model) {
        brand = brand.toLowerCase();
        model = model.toLowerCase();

        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getBrand().toLowerCase().contains(brand) && vehicle.getModel().toLowerCase().contains(model)) 
            	if (vehicle.isAvailable())
                	return vehicle;
        }
        return null;
    }
	
    /**
     * Marks a vehicle as rented (unavailable) if it is currently available.
     * 
     * @param vehicle the vehicle to rent
     * @return true if the vehicle was successfully rented, false otherwise
     */
	public boolean rentVehicle(Vehicle vehicle) {
	    if (vehicle.isAvailable()) {
	        vehicle.setAvailable(false);
	        System.out.println("Vehicle rented: " + vehicle.getBrand() + " " + vehicle.getModel());
	        return true;
	    } else {
	        System.out.println("Vehicle is already rented.");
	        return false;
	    }
	}
	
	/**
     * Marks a vehicle as returned (available) if it is currently rented.
     * 
     * @param vehicle the vehicle to return
     * @return true if the vehicle was successfully returned, false otherwise
     */
	public boolean returnVehicle(Vehicle vehicle) {
	    if (!vehicle.isAvailable()) {
	        vehicle.setAvailable(true);
	        System.out.println("Vehicle returned: " + vehicle.getBrand() + " " + vehicle.getModel());
	        return true;
	    } else {
	        System.out.println("Vehicle was not rented.");
	        return false;
	    }
	}
	
	/**
     * Displays all available vehicles in a formatted list.
     * <p>
     * Outputs to the console with brand, model, and price per day.
     * </p>
     */
	public void displayAvailableVehicles() {
	    System.out.println("-----------------------------------------------------------------------");
	    System.out.printf("%-10s %-10s %-10s %-10s %-12s\n", "Brand", "Model", "Price/Day", "Doors/CC", "Gear");
		System.out.println("-----------------------------------------------------------------------");
	    for (Vehicle vehicle : vehicleList) {
	        if (vehicle.isAvailable()) {
	            vehicle.displayDetails();
	        }
	    }
	}
}

