package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDAO;
import com.student.model.Student;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDAO studentDAO;
	
	public void enrollStudent(Student student) {
		studentDAO.enrollStudent(student);
	}
	public Student searchStudentById(String Id) {
		return studentDAO.searchStudentById(Id);
	}
	public List<Student> fetchAllStudents() {
		return studentDAO.fetchAllStudents();
	}
	public List<Student> getStudentbyHighestMarks() {
		return studentDAO.getStudentbyHighestMarks();
	}

}
