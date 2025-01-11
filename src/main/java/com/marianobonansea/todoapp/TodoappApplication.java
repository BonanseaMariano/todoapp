package com.marianobonansea.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Todoapp Spring Boot application.
 * This class contains the main method which uses Spring Boot's
 * SpringApplication.run() method to launch the application.
 */
@SpringBootApplication
public class TodoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

}
