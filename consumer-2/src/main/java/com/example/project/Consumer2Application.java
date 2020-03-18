package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@SpringBootApplication
@EnableEurekaClient
public class Consumer2Application {

	public static void main(String[] args) {
		SpringApplication.run(Consumer2Application.class, args);
	}
}
