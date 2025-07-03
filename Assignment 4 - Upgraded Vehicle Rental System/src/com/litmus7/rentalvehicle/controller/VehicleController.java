package com.litmus7.rentalvehicle.controller;

import java.util.List;

import com.litmus7.rentalvehicle.dto.*;
import com.litmus7.rentalvehicle.exception.DuplicateVehicleException;
import com.litmus7.rentalvehicle.exception.VehicleServiceException;
import com.litmus7.rentalvehicle.service.*;

/**
 * Controller class that acts as an interface between the user interface (UI)
 * layer and the service layer.
 * <p>
 * It provides methods to load, retrieve, add, search, rent, and return
 * vehicles, and wraps the results in standardized {@link Response} objects.
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class VehicleController {

	/**
	 * Status code indicating a successful operation.
	 */
	public static final int SUCCESS_CODE = 200;

	/**
	 * Status code indicating a failed operation.
	 */
	public static final int ERROR_CODE = 400;

	// Service instance
	private VehicleService vehicleService = new VehicleService();

	/**
	 * Loads vehicle data from a file.
	 *
	 * @param filePath the file path to load vehicles from
	 * @return a {@link Response} containing the list of loaded vehicles or an error
	 *         message
	 */
	public Response<String> loadVehiclesFromFile(String filePath) {
		Response<String> response = new Response<>();
		if (filePath != null) {
			try {
				response.setData(vehicleService.loadVehicles(filePath));
				response.setStatusCode(SUCCESS_CODE);
			} catch (VehicleServiceException e) {
				response.setStatusCode(ERROR_CODE);
				response.setErrorMessage(e.getMessage());
			}
		} else {
			response.setStatusCode(ERROR_CODE);
			response.setErrorMessage("Input filepath is invalid.");
		}

		return response;
	}

	/**
	 * Retrieves all vehicles currently managed by the system.
	 *
	 * @return a {@link Response} containing the list of all vehicles or an error
	 *         message
	 */
	public Response<List<Vehicle>> getAllVehicles() {
		Response<List<Vehicle>> response = new Response<>();
		try {
			response.setData(vehicleService.getAllVehicles());
			response.setStatusCode(SUCCESS_CODE);
		} catch (VehicleServiceException e) {
			response.setErrorMessage(e.getMessage());
			response.setStatusCode(ERROR_CODE);
		}
		return response;
	}

	/**
	 * Retrieves a list of all available vehicles for rent.
	 *
	 * @return a {@link Response} containing the list of available vehicles or an
	 *         error message
	 */
	public Response<List<Vehicle>> getAvailableVehicles() {
		Response<List<Vehicle>> response = new Response<>();
		try {
			response.setData(vehicleService.getAvailableVehicles());
			response.setStatusCode(SUCCESS_CODE);
		} catch (VehicleServiceException e) {
			response.setErrorMessage(e.getMessage());
			response.setStatusCode(ERROR_CODE);
		}
		return response;
	}

	/**
	 * Adds a new car to the system.
	 *
	 * @param brand  the brand of the car
	 * @param model  the model of the car
	 * @param price  the rental price per day
	 * @param doors  number of doors in the car
	 * @param isAuto whether the car is automatic
	 * @return a {@link Response} containing the added car or an error message
	 */
	public Response<Vehicle> addCar(String brand, String model, double price, int doors, boolean isAuto) {
		Response<Vehicle> response = new Response<>();
		try {
			response.setData(vehicleService.addVehicle(new Car(brand, model, price, doors, isAuto)));
			response.setStatusCode(SUCCESS_CODE);
		} catch (DuplicateVehicleException e) {
			response.setErrorMessage("Cannot Add " + model + " : " + brand + e.getMessage());
			response.setStatusCode(ERROR_CODE);
		}
		return response;
	}

	/**
	 * Adds a new bike to the system.
	 *
	 * @param brand          the brand of the bike
	 * @param model          the model of the bike
	 * @param price          the rental price per day
	 * @param hasGear        whether the bike has gears
	 * @param engineCapacity the engine capacity of the bike
	 * @return a {@link Response} containing the added bike or an error message
	 */
	public Response<Vehicle> addBike(String brand, String model, double price, boolean hasGear, int engineCapacity) {
		Response<Vehicle> response = new Response<>();
		try {
			response.setData(vehicleService.addVehicle(new Bike(brand, model, price, hasGear, engineCapacity)));
			response.setStatusCode(SUCCESS_CODE);
		} catch (DuplicateVehicleException e) {
			response.setErrorMessage("Cannot Add " + model + " : " + brand + e.getMessage());
			response.setStatusCode(ERROR_CODE);
		}
		return response;
	}

	/**
	 * Searches for a vehicle by brand and model.
	 *
	 * @param brand the brand to search for
	 * @param model the model to search for
	 * @return a {@link Response} containing the matching vehicle or an error
	 *         message
	 */
	public Response<Vehicle> searchVehicle(String brand, String model) {
		Response<Vehicle> response = new Response<>();
		if (brand != null || model != null) {
			try {
				Vehicle vehicle = vehicleService.searchVehicles(brand, model);
				response.setData(vehicle);
				response.setStatusCode(SUCCESS_CODE);
			} catch (VehicleServiceException e) {
				response.setStatusCode(ERROR_CODE);
				response.setErrorMessage(e.getMessage());
			}
		} else {
			response.setStatusCode(ERROR_CODE);
			response.setErrorMessage("Invalid Brand or Model");
		}
		return response;
	}

	/**
	 * Rents the specified vehicle if available.
	 *
	 * @param vehicle the vehicle to rent
	 * @return a {@link Response} containing the rented vehicle or an error message
	 */
	public Response<Vehicle> rentVehicle(Vehicle vehicle) {
		Response<Vehicle> response = new Response<>();
		if (vehicle != null) {
			try {
				Vehicle rentedVehicle = vehicleService.rentVehicle(vehicle);
				response.setStatusCode(SUCCESS_CODE);
				response.setData(rentedVehicle);
			} catch (VehicleServiceException e) {
				response.setStatusCode(ERROR_CODE);
				response.setErrorMessage(e.getMessage());
			}
		} else {
			response.setStatusCode(ERROR_CODE);
			response.setErrorMessage("Invalid vehicle given");
		}
		return response;
		
	}

	/**
	 * Returns the specified vehicle (makes it available again).
	 *
	 * @param vehicle the vehicle to return
	 * @return a {@link Response} containing the returned vehicle or an error
	 *         message
	 */
	public Response<Vehicle> returnVehicle(Vehicle vehicle) {
		Response<Vehicle> response = new Response<>();
		if (vehicle != null) {
			try {
				Vehicle returnedVehicle = vehicleService.returnVehicle(vehicle);
				response.setStatusCode(SUCCESS_CODE);
				response.setData(returnedVehicle);
			} catch (VehicleServiceException e) {
				response.setStatusCode(ERROR_CODE);
				response.setErrorMessage(e.getMessage());
			}
		} else {
			response.setStatusCode(ERROR_CODE);
			response.setErrorMessage("Invalid vehicle given");
		}
		return response;
	}
}
