package com.student.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.student.model.Student;
import com.student.utility.StudentMapper;

/**
 * 
 * @author Prakash/Sandeep
 *
 *         This DAO implementation class is to insert/retrieve the data from
 *         DataBase.
 */
@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * Insert student record in Student table.
	 */
	public int enrollStudent(Student student) {

		System.out.println(student.getStudentId() + " " + student.getStudentName() + " " + student.getStudentMarks());
		int result = jdbcTemplate.update("INSERT INTO Student (studentId, studentName, studentMarks) VALUES (?, ?, ?)",
				student.getStudentId(), student.getStudentName(), student.getStudentMarks());
		return result;
	}

	/**
	 * To retrieve student records from DB based on student id.
	 */
	public Student searchStudentById(int studentId) {
		return jdbcTemplate.queryForObject("select * from student where studentId = ?", new Object[] { studentId },
				new StudentMapper() {

				});

	}

	/**
	 * Retrieve all student records from DataBase.
	 */
	public List<Student> fetchAllStudents() {
		return jdbcTemplate.query("select * from student", new StudentMapper());

	}

	/**
	 * Get student records based on highest marks.
	 */
	public Student getStudentbyHighestMarks() {
		return jdbcTemplate.queryForObject("select * from student order by studentMarks desc limit 1",
				new StudentMapper());
	}

}
