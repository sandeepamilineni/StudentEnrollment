package com.student.main;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.model.Student;
import com.student.service.StudentService;
import com.student.utility.StudentUtil;

@Component
public class StudentEnrollment {

	/**
	 * Autowired StudentService
	 */
	@Autowired
	StudentService studentService;

	/**
	 * Autowired StudentUtil
	 */
	@Autowired
	StudentUtil studentUtil;

	/**
	 * To dispaly options in the console and choose the option from the list.
	 */
	public void displayMenu() {
		while (true) {
			System.out.println("*****************************************************");
			System.out.println(
					"1. Insert Student Record  \n2. Search Student record by ID  \n3. Fetch all Student records \n4. Get Student  record with highest score \n5. Exit from menu");
			Scanner scanner = new Scanner(System.in);
			System.out.println("*****************************************************");
			System.out.println("Choose an option from the above list:\n");
			String selectedChoice = scanner.next();
			int selectedChoiceInt = Integer.parseInt(selectedChoice.trim());
			if (selectedChoiceInt <= 4) {
				switch (selectedChoiceInt) {
				case 1:
					addStudent(new Student());
					break;
				case 2:
					searchStudentById();
					break;
				case 3:
					fetchAllStudents();
					break;
				case 4:
					getStudentbyHighestMarks();
					break;
				}
			} else if (selectedChoice.equals("5")) {
				System.out.println("Exit from Menu");
				break;
			} else {
				System.out.println("**Please choose an option between 1 to 5 **");
			}
		}
	}

	/**
	 * Insert student details in Database
	 * 
	 * @param student
	 * @return value
	 */
	public int addStudent(Student student) {
		String enteredData[] = new String[3];
		System.out.println("Enter StudentId\t studentName\t studentMarks\t");
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			enteredData[i] = scanner.next();
		}
		String studentId = enteredData[0];
		String studentName = enteredData[1];
		String studentMarks = enteredData[2];
		// Set the data to student object.
		student.setStudentId(studentId);
		student.setStudentName(studentName);
		student.setStudentMarks(Integer.parseInt(studentMarks));
		int result = studentService.enrollStudent(student);
		return result;

	}

	/**
	 * Get the student details by id from Database.
	 */
	public void searchStudentById() {
		try {
			System.out.println("Please Enter StudentId");
			Scanner scanner = new Scanner(System.in);
			int studentId = scanner.nextInt();
			Student student = studentService.searchStudentById(studentId);
			System.out.println("StudentId\t studentName\t studentMarks");
			System.out.println(
					student.getStudentId() + "\t\t" + student.getStudentName() + "\t\t" + student.getStudentMarks());
		} catch (Exception e) {
			System.out.println("Student record is not availabe in the database");
		}

	}

	/**
	 * fetch student records from DB
	 */
	public void fetchAllStudents() {
		System.out.println("****Fetch all student records****");
		List<Student> studentList = studentService.fetchAllStudents();
		Collections.sort(studentList);
		System.out.println("StudentId\t StudentName\t StudentMarks");
		for (Student student : studentList) {

			System.out.println(
					student.getStudentId() + "\t\t" + student.getStudentName() + "\t\t" + student.getStudentMarks());
		}
		System.out.println("Student records loaded successfully");
	}

	/**
	 * fethch student record based on the highest marks
	 */
	public void getStudentbyHighestMarks() {
		System.out.println("****Fetch Highest marks****");
		Student highestStudent = (Student) studentService.getStudentbyHighestMarks();

		System.out.println("StudentId  \t Student Name \t Marks");

		System.out.println(highestStudent.getStudentId() + "\t\t" + highestStudent.getStudentName() + "\t\t"
				+ highestStudent.getStudentMarks());
		studentUtil.serializeStudentDetails(highestStudent);
	}

}
