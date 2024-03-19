package com.jpa.JPAdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpAdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpAdemoApplication.class, args);
		System.out.println("JPA is running...");
	}

}
