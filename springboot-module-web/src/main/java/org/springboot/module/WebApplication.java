package org.springboot.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "org.springboot.module" })
@SpringBootApplication
public class WebApplication {
	public static void main(String[] args) {
		System.out.println("web application begin start...");

		SpringApplication.run(WebApplication.class, args);

		System.out.println("web application is running...");
	}
}
