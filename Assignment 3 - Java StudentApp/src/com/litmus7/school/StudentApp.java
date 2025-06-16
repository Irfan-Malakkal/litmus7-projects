package com.litmus7.school;

import com.litmus7.school.dto.Student;
import java.util.Scanner;

/**
 * The entry point of the application that handles multiple student records.
 * <p>
 * This class is responsible for:
 * <ul>
 * <li>Accepting the number of students</li>
 * <li>Collecting individual student details</li>
 * <li>Printing the report card for each student</li>
 * </ul>
 * </p>
 * 
 * @author Muhammed Irfan
 * @version 1.0
 */
public class StudentApp {

	/**
	 * The main method to run the student grading application. It collects data for
	 * multiple students and prints report cards.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Prompt user for number of students
		System.out.println("Enter Number of Students");
		int numStudents = scanner.nextInt();

		// Create an array to hold Student objects
		Student students[] = new Student[numStudents];

		// Loop to collect details for each student
		for (int i = 0; i < numStudents; i++) {
			System.out.println("Enter Student Number " + (i + 1) + "'s Details");
			students[i] = new Student(); // Instantiate student
			students[i].inputDetails(); // Get student input
		}

		// Loop to print the report card for each student
		for (Student student : students) {
			student.printReportCard();
		}

		// Close the scanner resource
		scanner.close();
	}

}
