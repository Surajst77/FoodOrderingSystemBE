package com.boot.fos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
public class FosApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FosApplication.class, args);
		
	
	}
	}
