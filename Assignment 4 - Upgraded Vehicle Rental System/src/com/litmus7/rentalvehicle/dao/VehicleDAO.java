package com.litmus7.rentalvehicle.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.rentalvehicle.dto.Bike;
import com.litmus7.rentalvehicle.dto.Car;
import com.litmus7.rentalvehicle.dto.Vehicle;
import com.litmus7.rentalvehicle.exceptions.*;


/**
 * Data Access Object (DAO) class responsible for loading vehicle data
 * from external sources such as files.
 * <p>
 * This class currently supports loading vehicles from a CSV file
 * where each line represents a vehicle in the following format:
 * <ul>
 * <li>For Cars: {@code Car,brand,model,price,doors,isAutomatic}</li>
 * <li>For Bikes: {@code Bike,brand,model,price,hasGear,engineCapacity}</li>
 * </ul>
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class VehicleDAO {
	/**
	 * List that holds all vehicles available or rented.
	 */
	private List<Vehicle> vehicles = new ArrayList<>();

	/**
	 * Loads vehicle data from a file and adds them to the vehicle list.
	 * <p>
	 * The file must be in a comma-separated format, with the first field indicating
	 * the vehicle type (e.g., Car or Bike).
	 * </p>
	 * 
	 * @param filePath the path to the file containing vehicle data
	 */
	public List<Vehicle> loadVehiclesFromFile(String filePath) throws VehicleDataAccessException {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				Vehicle vehicle = parseVehicle(line);
				if (vehicle != null)
					vehicles.add(vehicle);
			}
		} catch (FileNotFoundException e) {
			throw new VehicleDataAccessException(filePath, e);
		} catch (IOException e) {
			throw new VehicleDataAccessException(filePath, e);
		}

		return vehicles;
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
			return new Car(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
					Integer.parseInt(parts[4].trim()), Boolean.parseBoolean(parts[5].trim()));
		case "Bike":
			return new Bike(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
					Boolean.parseBoolean(parts[4].trim()), Integer.parseInt(parts[5].trim()));
		default:
			System.err.println("Unknown vehicle type: " + type);
			return null;
		}
	}
}
