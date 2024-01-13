package com.erbaris.app.flightsearch.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.erbaris")
public class FlightAddSchedulerSerivceApp {
    public static void main(String[] args) {
        SpringApplication.run(FlightAddSchedulerSerivceApp.class, args);
    }
}
