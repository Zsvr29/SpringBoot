package com.amigocode.code2;

import com.amigocode.code2.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication

public class Code2Application {

	public static void main(String[] args) {
		SpringApplication.run(Code2Application.class, args);
	}


}
