package org.springboot.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class modelApplication {
	public static void main(String[] args) {
		System.out.println("model application begin start...");
		SpringApplication.run(modelApplication.class, args);
		System.out.println("model application is running...");
	}
}
