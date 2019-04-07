package com.web.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.web.start, com.web.entities, com.web.repositories, com.web.services")
@EntityScan(basePackages="com.web.entities")
@EnableJpaRepositories(basePackages="com.web.repositories")
public class TechnoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnoAppApplication.class, args);
	}

}
