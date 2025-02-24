package com.spring.Spring_Greeting_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.spring.Spring_Greeting_App.repository")
public class SpringGreetingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGreetingAppApplication.class, args);
	}

}
