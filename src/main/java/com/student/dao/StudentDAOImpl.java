package com.student.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.student.model.Student;
@Repository
public class StudentDAOImpl implements StudentDAO{
	
	public void enrollStudent(Student student) {
		System.out.println(student.getStudentId() + " " +student.getStudentName() + " " +student.getStudentMarks());
		
	}
	public Student searchStudentById(String Id) {
		return null;
	}
	public List<Student> fetchAllStudents() {
		return null;
	}
	public Student getStudentbyHighestMarks() {
		return null;
	}

}
