package com.student.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.student.model.Student;
import com.student.utility.StudentMapper;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void enrollStudent(Student student) {
		
		System.out.println(student.getStudentId() + " " +student.getStudentName() + " " +student.getStudentMarks());
		jdbcTemplate.update(
			    "INSERT INTO Student (id, name, marks) VALUES (?, ?, ?)",
			    student.getStudentId(), student.getStudentName(),student.getStudentMarks()
			);
	}
	public Student searchStudentById(String Id) {
		return jdbcTemplate.queryForObject("select * from student where id = ?",new Object[]{Id}, new StudentMapper());
		
	}
	public List<Student> fetchAllStudents() {
		return jdbcTemplate.query("select * from student", new StudentMapper() );
		
	}
	public List<Student> getStudentbyHighestMarks() {
		return jdbcTemplate.query("select * from giffgaff.student a where a.marks = (select max(b.marks) from giffgaff.student b) "
				,new StudentMapper() );
	}

}
