package com.delibot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.delibot"})
@EnableJpaRepositories("com.delibot")
@EntityScan("com.delibot.domain")

public class DeliBotApplication {

	private static final Logger LOGGER= LoggerFactory.getLogger(DeliBotApplication.class);
	public static void main(String[] args) {

		LOGGER.debug("Inside Delibot application");
		SpringApplication.run(DeliBotApplication.class, args);
	}

}
