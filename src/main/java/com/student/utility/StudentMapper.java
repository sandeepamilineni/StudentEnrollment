package com.student.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import com.student.model.Student;
	
public class StudentMapper implements RowMapper<Student> {
	@Autowired
	Student student;
	
	   public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	      
	      student.setStudentId(rs.getString("id"));
	      student.setStudentName((rs.getString("name")));
	      student.setStudentMarks((rs.getInt("marks")));
	      
	      return student;
	   }
	}
