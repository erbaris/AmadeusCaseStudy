package com.erbaris.app.flightsearch.scheduler.runner;

import com.erbaris.app.flightsearch.scheduler.runner.service.FlightSearchService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@EnableScheduling
public class SchedulerRunner {
    private FlightSearchService m_flightSearchService;

    public SchedulerRunner(FlightSearchService flightSearchService) {
        m_flightSearchService = flightSearchService;
    }

    @Scheduled(cron = "0 0 1 * * *")
    private void schedule()
    {
        System.out.println(DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss").format(LocalDateTime.now()) + " -> Scheduled operation is running...");
        operation(1000);
        System.out.println(DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss").format(LocalDateTime.now()) + " -> Scheduled operation finished...");
    }

    public void operation(int quantity)
    {
        for(int i = 0; i < quantity; i++){
            var flight = m_flightSearchService.generateAndSaveRandomFlight();
            System.out.println("Added Flight Information: " + flight);
        }
    }
}
