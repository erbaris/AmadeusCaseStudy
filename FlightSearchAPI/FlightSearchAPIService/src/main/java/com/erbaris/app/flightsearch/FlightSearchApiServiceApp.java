package com.erbaris.app.flightsearch;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.erbaris")
@EntityScan(basePackages = "com.erbaris")
@OpenAPIDefinition(
        info = @Info(
                title = "Barış ER - Flight Search API Project",
                version = "1.0.0",
                description = "This porject has been done for Amadeus Travel to Future Program",
                termsOfService = "termsofservice",
                contact = @Contact(
                        name = "Barış ER",
                        email = "erbaris@yahoo.com"
                ),
                license = @License(
                        name = "licence",
                        url = "licence"
                )
        )
)
public class FlightSearchApiServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(FlightSearchApiServiceApp.class, args);
    }

}
