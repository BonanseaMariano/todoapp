package com.marianobonansea.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;

/**
 * The main entry point for the Todoapp Spring Boot application.
 * This class contains the main method which uses Spring Boot's
 * SpringApplication.run() method to launch the application.
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API de Gestión de Tareas", version = "1.0", description = "API REST para gestionar tareas pendientes", contact = @Contact(name = "Mariano Bonansea", email = "marianobonanseapetrovial@gmail.com"), license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html")))
public class TodoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

}
