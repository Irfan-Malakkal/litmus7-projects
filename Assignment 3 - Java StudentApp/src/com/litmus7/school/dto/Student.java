package com.litmus7.school.dto;

import java.util.Scanner;

public class Student {
	int rollNumber;
	String name;
	int marks[] = new int[5];
	
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
	
	public int calculateTotal() {
		int total = 0;
		
		for(int mark : marks) {
			total += mark;
		}
		return total;
	}
	
	public double calculateAverage() {
		return calculateTotal()/5.0;
	}
	
	public char getGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return 'A';
        } 
        else if (average >= 75) {
            return 'B';
        } 
        else if (average >= 60) {
            return 'C';
        } 
        else if (average >= 50) {
            return 'D';
        } 
        else {
            return 'F';
        }
    }
	
	public void printReportCard() {
        System.out.println("\n----- Report Card -----");
        System.out.println("Name\t\t: " + name);
        System.out.println("Roll No\t\t: " + rollNumber);
        System.out.println("Total Marks\t: " + calculateTotal());
        System.out.printf("Average Marks\t: %.2f\n", calculateAverage());
        System.out.println("Grade\t\t: " + getGrade());
    }
}
