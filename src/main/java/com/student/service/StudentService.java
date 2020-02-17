package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
	public int enrollStudent(Student student);
	public Student searchStudentById(int sid);
	public List<Student> fetchAllStudents() ;
	public Student getStudentbyHighestMarks();

}
