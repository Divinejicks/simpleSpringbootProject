package com.divinejicks.schoolmanager.sms.schoolmanagementsms;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Faculty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SchoolmanagementSmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolmanagementSmsApplication.class, args);
	}
	@GetMapping("")
	Faculty getFaculty(){
		return new Faculty();
	}
}