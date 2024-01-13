package com.erbaris.app.flightsearch.random;

import com.erbaris.app.flightsearch.data.entity.Flight;
import com.erbaris.app.flightsearch.service.FlightSearchAppService;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Scope("prototype")
public class RandomFlightGenerator {
    private final RandomAirportGenerator m_randomAirportGenerator;

    public RandomFlightGenerator(RandomAirportGenerator randomAirportGenerator) {
        m_randomAirportGenerator = randomAirportGenerator;
    }
    @Transactional
    public Flight getRandomFlightandSave(FlightSearchAppService flightSearchAppService)
    {
        Random r = new Random();
        Flight f = new Flight();
        f.departureAirport = m_randomAirportGenerator.getRandomAirport(flightSearchAppService);
        f.destinationAirport = m_randomAirportGenerator.getRandomAirport(flightSearchAppService);
        f.departureDate = LocalDate.now().plusDays(r.nextLong(10));
        f.departureTime = LocalTime.now().plusHours(r.nextLong(10));
        f.price = r.nextLong(100, 10000);
        return flightSearchAppService.flightSave(f);
    }
    public List<Flight> genareteFlightsAndSave(int quantity,FlightSearchAppService flightSearchAppService)
    {
        ArrayList<Flight> flights = new ArrayList<>();
        for(int i = 0; i < quantity; i++)
            flights.add(getRandomFlightandSave(flightSearchAppService));
        return flights;
    }

}
