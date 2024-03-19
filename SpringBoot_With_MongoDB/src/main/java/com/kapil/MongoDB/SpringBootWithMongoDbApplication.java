package com.kapil.MongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWithMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMongoDbApplication.class, args);
		System.out.println("Spring with mongoDb running...");
	}

}
