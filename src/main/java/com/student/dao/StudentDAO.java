package com.student.dao;

import java.util.List;

import com.student.model.Student;

public interface StudentDAO {
	public void enrollStudent(Student student);
	public Student searchStudentById(String Id);
	public List<Student> fetchAllStudents() ;
	public List<Student> getStudentbyHighestMarks();
}
