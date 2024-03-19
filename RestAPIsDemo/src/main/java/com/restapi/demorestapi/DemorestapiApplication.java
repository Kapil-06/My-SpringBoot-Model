package com.restapi.demorestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemorestapiApplication {
	
	//static data pass to constructor and show the output
	public static void main(String[] args) {
		SpringApplication.run(DemorestapiApplication.class, args);
		System.out.println("Rest Apis project running...");
	}
	
}
