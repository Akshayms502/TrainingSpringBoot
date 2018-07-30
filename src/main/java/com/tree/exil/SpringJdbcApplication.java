package com.tree.exil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.tree.exil")
@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}
}
