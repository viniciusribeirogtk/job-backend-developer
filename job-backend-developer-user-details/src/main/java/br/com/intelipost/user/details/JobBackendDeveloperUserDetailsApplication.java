package br.com.intelipost.user.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JobBackendDeveloperUserDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobBackendDeveloperUserDetailsApplication.class, args);
	}
}
