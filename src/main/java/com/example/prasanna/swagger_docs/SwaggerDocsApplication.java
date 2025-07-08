package com.example.prasanna.swagger_docs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Student Application Rest API",
				description = "Documentation for Student Application Rest API",
				version = "v1"
		)
)
public class SwaggerDocsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerDocsApplication.class, args);
	}

}
