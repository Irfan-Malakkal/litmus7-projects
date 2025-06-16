package com.litmus7.school.dto;

import java.util.Scanner;

/**
 * Represents a student with a name, roll number, and marks for 5 subjects.
 * 
 * <p>
 * This class allows input of student details, computes total and average marks,
 * determines the grade using an internal enum {@link Grade}, and prints a
 * formatted report card with grade descriptions.
 * </p>
 * 
 * @author Muhammed Irfan
 * @version 1.0
 */
public class Student {

	/** Roll number of the student */
	private int rollNumber;

	/** Name of the student */
	private String name;

	/** Array to store marks for 5 subjects */
	private int marks[] = new int[5];

	/**
	 * Inputs student details including name, roll number, and marks for 5 subjects
	 * using the console.
	 */
	public void inputDetails() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Student Name");
		name = scanner.nextLine();

		System.out.println("Enter Roll Number");
		rollNumber = scanner.nextInt();

		System.out.println("Enter marks for 5 subjects:");
		for (int i = 0; i < 5; i++) {
			System.out.print("Subject " + (i + 1) + ": ");
			marks[i] = scanner.nextInt();
		}
	}

	/**
	 * Calculates the total marks obtained across all 5 subjects.
	 *
	 * @return total marks
	 */
	private int calculateTotal() {
		int total = 0;
		for (int mark : marks) {
			total += mark;
		}
		return total;
	}

	/**
	 * Calculates the average marks.
	 *
	 * @return average marks as a double
	 */
	private double calculateAverage() {
		return calculateTotal() / 5.0;
	}

	/**
	 * Enum representing possible grades and their associated descriptions.
	 */
	public enum Grade {
		A("Excellent"), B("Good"), C("Average"), D("Pass"), F("Fail");

		/** Description associated with the grade */
		private final String description;

		/**
		 * Constructor for Grade enum.
		 *
		 * @param description a brief description of the grade
		 */
		Grade(String description) {
			this.description = description;
		}

		/**
		 * Gets the description of the grade.
		 *
		 * @return grade description
		 */
		public String getDescription() {
			return description;
		}
	}

	/**
	 * Determines the grade based on the average marks.
	 *
	 * @return grade as a {@link Grade} enum
	 */
	private Grade getGrade() {
		double average = calculateAverage();

		if (average >= 90) {
			return Grade.A;
		} else if (average >= 75) {
			return Grade.B;
		} else if (average >= 60) {
			return Grade.C;
		} else if (average >= 50) {
			return Grade.D;
		} else {
			return Grade.F;
		}
	}

	/**
	 * Prints the report card with student details, total marks, average, and grade
	 * (with a description).
	 */
	public void printReportCard() {
		Grade grade = getGrade();

		System.out.println("\n----- Report Card -----");
		System.out.println("Name\t\t: " + name);
		System.out.println("Roll No\t\t: " + rollNumber);
		System.out.println("Total Marks\t: " + calculateTotal());
		System.out.printf("Average Marks\t: %.2f\n", calculateAverage());
		System.out.println("Grade\t\t: " + grade + " (" + grade.getDescription() + ")");
	}
}
