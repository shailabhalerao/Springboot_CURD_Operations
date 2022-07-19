package com.hcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.hcl" })
public class SpringBootCurdOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCurdOperationsApplication.class, args);
	}

}
