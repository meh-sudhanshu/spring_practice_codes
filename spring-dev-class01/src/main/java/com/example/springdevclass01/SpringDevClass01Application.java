package com.example.springdevclass01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"controllers1","controllers2"}
)
public class SpringDevClass01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDevClass01Application.class, args);
	}

}
