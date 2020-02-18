package com.student.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.student.model.Student;

@Component
public class StudentUtil {

	public void serializeStudentDetails(Student student) {

		try {
			System.out.println("Write student data into file");
			File file = ResourceUtils.getFile("student.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
			objectOutputStream.writeObject(student);
			objectOutputStream.flush();
			objectOutputStream.close();
			System.out.println("Student object searialized into a file successfully");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
