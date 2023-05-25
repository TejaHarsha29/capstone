package com.medicalservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MedicalservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalservicesApplication.class, args);
	}

}
