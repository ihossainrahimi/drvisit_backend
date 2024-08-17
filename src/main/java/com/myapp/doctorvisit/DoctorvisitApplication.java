package com.myapp.doctorvisit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableScheduling
@EnableWebSecurity
@SpringBootApplication
public class DoctorvisitApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorvisitApplication.class, args);
	}

}
