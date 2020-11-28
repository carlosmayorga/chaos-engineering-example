package com.cmayorga.saving.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.cmayorga.common.models.library.entity"})
public class SavingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SavingServiceApplication.class, args);
	}

}
