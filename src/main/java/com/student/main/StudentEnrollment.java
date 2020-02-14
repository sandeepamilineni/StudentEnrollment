package com.student.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.student.model.Student;
import com.student.service.StudentService;
@Component
public class StudentEnrollment {
	
	@Autowired
	Student student;
	
	@Autowired
	StudentService studentService;
	
	
	
	public void displayMenu() {
					
		System.out.println(" 1. Enroll Student \n 2. Search Student by ID  \n 3. Fetch all Students \n 4. Get Student with highest score");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter index of selected choice : ");
		String selectedChoice = scanner.next();
		if(selectedChoice !=null) {
			int  selectedChoiceInt = Integer.parseInt(selectedChoice.trim());
			switch(selectedChoiceInt) {
				case 1 : enrollStudent();
						 break;
				case 2 : searchStudentById();
						break;
				case 3 : fetchAllStudents();
						break;
				case 4 : getStudentbyHighestMarks();
						break;
			}
			
		}
		
	}
	
	public void enrollStudent() {

		String enteredData[] = new String[3];
		System.out.println("Enter Student ID & Name & Marks \n");
		Scanner scanner = new Scanner(System.in);
        for(int i =0; i<3;i++ ) {
        	enteredData[i]= scanner.next();
		}
        scanner.close();
        student.setStudentId(enteredData[0]);
        student.setStudentName(enteredData[1]);
        student.setStudentMarks(Integer.parseInt(enteredData[2]));
        studentService.enrollStudent(student);
		
	}
	
	public Student searchStudentById() {
		
		return null;
	}
	
	public List<Student> fetchAllStudents() {
		return null;
	}
	
	public Student getStudentbyHighestMarks() {
		return null;
	}

}
