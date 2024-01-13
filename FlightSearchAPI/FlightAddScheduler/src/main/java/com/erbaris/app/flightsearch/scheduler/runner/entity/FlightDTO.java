package com.erbaris.app.flightsearch.scheduler.runner.entity;

import com.erbaris.app.flightsearch.data.entity.Airport;
import com.erbaris.app.flightsearch.data.entity.Flight;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FlightDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Airport departureAirport;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Airport destinationAirport;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LocalDate departureDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LocalTime departureTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public long price;

    @Override
    public int hashCode()
    {
        return Long.hashCode(id);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Flight flight && flight.id == id;
    }

    @Override
    public String toString() {
        return "Flight Id: " + id + " Departure Aiport: " + departureAirport.id + " Destination Airport: " + destinationAirport.id + " Date: " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(departureDate) + " Time: " + DateTimeFormatter.ofPattern("hh:mm:ss").format(departureTime);
    }
}
