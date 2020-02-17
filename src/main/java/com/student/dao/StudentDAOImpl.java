package com.student.dao;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.student.model.Student;
import com.student.utility.StudentMapper;

/**
 * 
 * @author Prakash/Sandeep
 *
 *         This DAO implementation class is to insert/retrieve the data from DB.
 */
@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	private static final Logger log = Logger.getLogger(StudentDAOImpl.class.getName());

	/**
	 *
	 * This implementation is to insert student record in Student database
	 */
	public int enrollStudent(Student student) {

		log.info(student.getStudentId() + " " + student.getStudentName() + " " + student.getStudentMarks());
		int result = jdbcTemplate.update("INSERT INTO Student (studentId, studentName, studentMarks) VALUES (?, ?, ?)",
				student.getStudentId(), student.getStudentName(), student.getStudentMarks());
		return result;
	}

	/**
	 * This implementation is to retrieve student records from DB based on student
	 * id.
	 */
	public Student searchStudentById(int studentId) {
		return jdbcTemplate.queryForObject("select * from student where studentId = ?", new Object[] { studentId },
				new StudentMapper() {
			
		});

	}

	/**
	 * This implementation is to retrieve all student records from DB.
	 */
	public List<Student> fetchAllStudents() {
		return jdbcTemplate.query("select * from student", new StudentMapper());

	}

	/**
	 * This implementation is to get student records based on highest marks.
	 */
	public Student getStudentbyHighestMarks() {
		return  jdbcTemplate.queryForObject(
				"select * from student order by studentMarks desc limit 1",
				new StudentMapper());
	}

}
