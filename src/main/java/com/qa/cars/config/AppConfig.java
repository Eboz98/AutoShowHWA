package com.qa.cars.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public String message() {
		return "Welcome to my AutoShow";
	}

}
