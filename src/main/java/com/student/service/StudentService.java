package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
	public void enrollStudent(Student student);
	public Student searchStudentById(String Id);
	public List<Student> fetchAllStudents() ;
	public Student getStudentbyHighestMarks();

}
