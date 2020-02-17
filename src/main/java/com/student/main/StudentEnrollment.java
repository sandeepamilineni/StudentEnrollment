package com.student.main;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.model.Student;
import com.student.service.StudentService;
import com.student.utility.StudentUtil;

@Component
public class StudentEnrollment {

	@Autowired
	Student student;

	@Autowired
	StudentService studentService;

	@Autowired
	StudentUtil studentUtil;

	private static final Logger log = Logger.getLogger(StudentEnrollment.class.getName());

	public void displayMenu() {
		
		boolean exitMenu = false;
		
		log.info(
				"1. insert Student Record \n 2. Search Student record by ID  \n 3. Fetch all Student records \n 4. Get Student  record with highest score \n 5. Exit");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose option:\n");
		String selectedChoice = scanner.next();
		if (selectedChoice != null) {
			int selectedChoiceInt = Integer.parseInt(selectedChoice.trim());
			switch (selectedChoiceInt) {
			case 1:
				addStudent();
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
		}
	}

	public int addStudent() {

		String enteredData[] = new String[3];
		log.info("Enter Student ID, Name and Marks \n");
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			enteredData[i] = scanner.next();
		}
		scanner.close();
		student.setStudentId(enteredData[0]);
		student.setStudentName(enteredData[1]);
		student.setStudentMarks(Integer.parseInt(enteredData[2]));
		int result = studentService.enrollStudent(student);
		return result;

	}

	public void searchStudentById() {

		log.info("Please Enter Student Id");
		Scanner scanner = new Scanner(System.in);
		int studentId = scanner.nextInt();
		scanner.close();
		Student student = studentService.searchStudentById(studentId);
		System.out.println(student.getStudentId() + "\t" + student.getStudentName() + "\t" + student.getStudentMarks());
		log.info(student.getStudentId() + "\n" + student.getStudentName() + "\n" + student.getStudentMarks());

	}

	public void fetchAllStudents() {
		log.info("****Fetch all student records****");
		List<Student> studentList = studentService.fetchAllStudents();
		Collections.sort(studentList);
		System.out.println("StudentId  \t Student Name \t Marks");

		for (Student student : studentList) {

			System.out.println(student.getStudentId() + "\t" + student.getStudentName() + "\t" + student.getStudentMarks());
		}
		System.out.println("Student details loaded");

	}

	public void getStudentbyHighestMarks() {
		log.info("****Fetch Highest marks****");
		Student highestStudent = (Student) studentService.getStudentbyHighestMarks();

		System.out.println("StudentId  \t Student Name \t Marks");

		System.out.println(highestStudent.getStudentId() + "\t" + highestStudent.getStudentName() + "\t" + highestStudent.getStudentMarks());
		studentUtil.serializeStudentDetails(highestStudent);
		log.info("Student details has been loaded into file");

	}

}
