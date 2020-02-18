package com.student.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Student implements Serializable, Comparable<Student> {

	private String studentId;
	private String studentName;
	private int studentMarks;

	public Student() {
	}

	public Student(String studentId, String studentName, int studentMarks) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMarks = studentMarks;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}

	@Override
	public int compareTo(Student student) {
		if (studentMarks == student.studentMarks)
			return 0;
		else if (studentMarks > student.studentMarks)
			return 1;
		else
			return -1;
	}

}
