package com.aluraCursos.desafioForoApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.aluraCursos.desafioForoApi")
public class DesafioForoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioForoApiApplication.class, args);
	}


}
