package org.springboot.module;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.springboot.module.mapper")
@SpringBootApplication
public class modelApplication {
	public static void main(String[] args) {
		System.out.println("model application begin start...");
		SpringApplication.run(modelApplication.class, args);
		System.out.println("model application is running...");
	}
}
