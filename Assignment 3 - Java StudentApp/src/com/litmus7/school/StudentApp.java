package com.litmus7.school;

import com.litmus7.school.dto.Student;
import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Number of Students");
		int numStudents = scanner.nextInt();
		
		Student students[] = new Student[numStudents];
		
		for(int i=0; i<numStudents;i++) {
			System.out.println("Enter Student Number "+(i+1) +"'s Details");
			students[i] = new Student();
			students[i].inputDetails();
		}
		
		for(Student student : students) {
			student.printReportCard();
		}
		
		scanner.close();
	}

}
