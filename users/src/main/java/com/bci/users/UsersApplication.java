package com.bci.users;

import com.bci.users.dto.ContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@OpenAPIDefinition(
		info = @Info(
				title = "Restrictive Bank System",
				description = "User registration API",
				version = "V1",
				contact = @Contact(
						name = "Melquis Jair Peralta Vega",
						email = "mejapeve@gmail.com",
						url = "https://www.devlops.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.devlops.com"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Project for user registration",
				url = "http://localhost:8070/swagger-ui/index.html"
		)
)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@EnableConfigurationProperties(value = ContactInfoDto.class)
public class UsersApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
