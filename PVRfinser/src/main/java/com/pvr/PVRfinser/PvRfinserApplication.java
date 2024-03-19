package com.pvr.PVRfinser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.pvr.PVRfinser")
public class PvRfinserApplication {

	public static void main(String[] args) {
		SpringApplication.run(PvRfinserApplication.class, args);
		System.out.println("PVR is running...");
	}

}
