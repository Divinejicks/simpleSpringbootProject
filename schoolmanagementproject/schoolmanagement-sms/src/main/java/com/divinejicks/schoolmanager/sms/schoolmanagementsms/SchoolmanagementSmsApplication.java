package com.divinejicks.schoolmanager.sms.schoolmanagementsms;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Faculty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

/**
 * Added this lines to solve the problem of
 * Not a manage type * @author jicks
 *
 */
@EnableJpaRepositories("my.package.base.*")
@ComponentScan(basePackages = { "my.package.base.*" })
@EntityScan("my.package.base.*")
public class SchoolmanagementSmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolmanagementSmsApplication.class, args);
	}
	@GetMapping("")
	Faculty getFaculty(){
		return new Faculty();
	}
}