package com.erbaris.app.flightsearch.random;

import com.erbaris.app.flightsearch.data.entity.Airport;
import com.erbaris.app.flightsearch.service.FlightSearchAppService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomAirportGenerator {
    private static final String m_alphabetEN = "ABCDEFGHIJKLMNOPQRSTUWXVYZ";

    public Airport getRandomAirport(FlightSearchAppService flightSearchAppService)
    {
        Random r = new Random();
        String id;
        do{
            id = getRandomText(r, 3, m_alphabetEN);
        }while(!isAirportbyId(id, flightSearchAppService));
        return flightSearchAppService.getAirportById(id);
    }
    public boolean isAirportbyId(String id, FlightSearchAppService flightSearchAppService)
    {
        return flightSearchAppService.airportExistById(id);
    }

    public String getRandomText(Random r, int n, String sourceText)
    {
        var sb = new StringBuilder(n);
        int length = sourceText.length();

        for (int i = 0; i < n; ++i)
            sb.append(sourceText.charAt(r.nextInt(length)));

        return sb.toString();
    }
}
