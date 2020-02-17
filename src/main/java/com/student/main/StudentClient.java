package com.student.main;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @author Sandeep/Prakash
 *
 */
public class StudentClient {
	
	
	private static final Logger log = Logger.getLogger(StudentClient.class.getName());
	public static void main(String[] args) {
		
		log.info("**Loading context class**");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		StudentEnrollment studentEnrollment = context.getBean(StudentEnrollment.class);
		studentEnrollment.displayMenu();
		context.close();
		log.info("Closed context class");
	}

}
