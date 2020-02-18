package com.student.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @author Sandeep/Prakash This class used to load application context and call
 *         StudentEnrollment bean
 */
public class StudentClient {

	public static void main(String[] args) {

		System.out.println("**Loading context class**");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		StudentEnrollment studentEnrollment = context.getBean(StudentEnrollment.class);
		studentEnrollment.displayMenu();
		System.out.println("Application context closed");
	}

}
