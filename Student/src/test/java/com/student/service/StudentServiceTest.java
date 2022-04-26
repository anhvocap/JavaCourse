package com.student.service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentServiceTest {
	
	private ApplicationContext context;
	private StudentService service;

	@BeforeEach
	void setUp() {
		context = new ClassPathXmlApplicationContext("beans.xml");
		service = context.getBean("studentService", StudentService.class);
	}
	
 
	@Test
	void testGetOneStudent() {
		assertNotNull(service);
	}
	
	@Test
	void tesGetAll() {
		service.getAllStudents().stream().forEach(st -> {
			System.out.println(st.toString());
		});		
	}
}
