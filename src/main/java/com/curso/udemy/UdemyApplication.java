package com.curso.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages ="com.curso.udemy.*")
@EnableJpaRepositories
public class UdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyApplication.class, args);
	}

}
