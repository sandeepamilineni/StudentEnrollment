package com.student.dao;

import java.util.List;

import com.student.model.Student;
/**
 * 
 * @author Prakash/Sandeep
 * 
 * 
 */
public interface StudentDAO {
	
	public int enrollStudent(Student student);

	public Student searchStudentById(int Id);

	public List<Student> fetchAllStudents();

	public Student getStudentbyHighestMarks();
}
