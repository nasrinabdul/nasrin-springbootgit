package org.example.springProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringProjectApplication.class, args);
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

}
