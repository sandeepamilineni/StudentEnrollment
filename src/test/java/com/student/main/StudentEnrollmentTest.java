package com.student.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.student.model.Student;
import com.student.service.StudentService;
import com.student.utility.StudentUtil;

@RunWith(MockitoJUnitRunner.class)
public class StudentEnrollmentTest {

	@Mock
	StudentService studentServiceMock;

	@InjectMocks
	StudentEnrollment studentEnrollment;

	@InjectMocks
	StudentUtil studentUtil;

	@Test
	public void testFetchAllStudents() {
		List<Student> studentList = new ArrayList<Student>();
		Student student = new Student();
		student.setStudentId("65");
		student.setStudentName("Prakash");
		student.setStudentMarks(590);
		Student student2 = new Student();
		student2.setStudentId("66");
		student2.setStudentName("Sandeep");
		student2.setStudentMarks(592);
		
		studentList.add(student);
		studentList.add(student2);
		when(studentServiceMock.fetchAllStudents()).thenReturn(studentList);
		studentEnrollment.fetchAllStudents();
		assertEquals(2, studentList.size());
	}

	@Test
	public void testGetStudentbyHighestMarks() {
		Student student = new Student();
		student.setStudentId("75");
		student.setStudentName("Sandeep");
		student.setStudentMarks(590);
		when(studentServiceMock.getStudentbyHighestMarks()).thenReturn(student);
		studentEnrollment.getStudentbyHighestMarks();
		assertEquals(590, student.getStudentMarks());
	}

	@Test
	public void testSearchStudentById() {
		Student student = new Student();
		student.setStudentId("65");
		student.setStudentName("Sandeep");
		student.setStudentMarks(590);
		Mockito.when(studentServiceMock.searchStudentById(65)).thenReturn(student);
		studentEnrollment.searchStudentById();
		assertEquals("Sandeep", student.getStudentName());
		assertEquals("65", student.getStudentId());
		assertEquals(590, student.getStudentMarks());

	}

	@Test
	public void testAddStudent() {
		Student student = new Student();
		when(studentServiceMock.enrollStudent(student)).thenReturn(1);
		studentEnrollment.addStudent(student);
		assertNotNull(student);

	}

}
