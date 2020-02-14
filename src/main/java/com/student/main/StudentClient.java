package com.student.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		StudentEnrollment studentEnrollment  = context.getBean(StudentEnrollment.class);
		studentEnrollment.displayMenu();

		context.close();
	}

}
