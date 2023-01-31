package com.seasolutions.vinicius.seasolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class ProjetoSeaSolutionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSeaSolutionsApplication.class, args);
	}

}
