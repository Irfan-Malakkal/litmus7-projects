/**
 * 
 */
package com.litmus7.rental;

import com.litmus7.rental.dto.*;

/**
 * This class serves as the entry point for the vehicle rental application.
 * <p>
 * It demonstrates the usage of the {@link Car} and {@link Bike} classes by:
 * <ul>
 *   <li>Creating objects using both default and parameterized constructors</li>
 *   <li>Reading vehicle details from user input</li>
 *   <li>Displaying the stored vehicle information</li>
 * </ul>
 * </p>

 * @author Muhammed Irfan
 */
public class VehicleApp {

    /**
     * The main method executes the application logic.
     * <p>
     * It creates instances of {@link Car} and {@link Bike}, invokes input and display methods,
     * and prints out both user-provided and hardcoded vehicle details.
     * </p>
     * 
     * @param args command-line arguments (not used)
     */
	public static void main(String[] args) {
		
		// Creating and displaying a Car using default constructor and user input
		Car car = new Car();
		System.out.println("--- Enter Car Details ---");
		car.inputDetails();
		System.out.println("--- Displaying Car Details ---");
		car.displayDetails();
		
		System.out.println();
		
		// Creating and displaying a Bike using default constructor and user input
		Bike bike = new Bike();
		System.out.println("--- Enter Bike Details ---");
		bike.inputDetails();
		System.out.println("--- Displaying Bike Details ---");
		bike.displayDetails();

		System.out.println();
		
		// Creating and displaying a Car using parameterized constructor
		Car car2 = new Car("Honda", "Civic", 1400.0, 4, false);
		System.out.println("--- Displaying Car Details (Parameterized) ---");
		car2.displayDetails();
		
		System.out.println();
		
		// Creating and displaying a Bike using parameterized constructor
		Bike bike2 = new Bike("Suzuki", "Gixxer", 600.0, false, 125);
		System.out.println("--- Displaying Bike Details (Parameterized) ---");
		bike2.displayDetails();
	}

}
