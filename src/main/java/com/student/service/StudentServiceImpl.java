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

	public int enrollStudent(Student student) {
		int result = studentDAO.enrollStudent(student);
		return result;
	}

	public Student searchStudentById(int sid) {
		Student student = studentDAO.searchStudentById(sid);
		return student;
	}

	public List<Student> fetchAllStudents() {
		List<Student> studentList = studentDAO.fetchAllStudents();
		return (List<Student>) studentList;
	}

	public Student getStudentbyHighestMarks() {
		Student student = (Student) studentDAO.getStudentbyHighestMarks();
		return student;
	}

}
