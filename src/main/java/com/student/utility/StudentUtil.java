package com.student.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.student.model.Student;

@Component
public class StudentUtil {

	private Logger log = Logger.getLogger(StudentUtil.class.getName());

	public void serializeStudentDetails(Student student) {

		try {
			File file = ResourceUtils.getFile("classpath:student.txt");
			System.out.println("File Found : " + file.exists());
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
			objectOutputStream.writeObject(student);
			objectOutputStream.flush();
			objectOutputStream.close(); 
			log.info("Student details loaded successfully");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
