package com.erbaris.app.flightsearch.data.dal;

import com.erbaris.app.flightsearch.data.entity.Airport;
import com.erbaris.app.flightsearch.data.entity.Flight;
import com.erbaris.app.flightsearch.data.repository.IAirportRepository;
import com.erbaris.app.flightsearch.data.repository.IFlightRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class FlightSearchAppHelper {
    private final IAirportRepository m_airportRepository;
    private final IFlightRepository m_flightRepository;

    public FlightSearchAppHelper(IAirportRepository airportRepository, IFlightRepository flightRepository) {
        m_airportRepository = airportRepository;
        m_flightRepository = flightRepository;
    }

    public Optional<Airport> findAirportById(String id)
    {
        return m_airportRepository.findById(id);
    }

    public List<Airport> findAirportByName(String name)
    {
        return m_airportRepository.findAirportByCityName(name);
    }

    public boolean airportExistById (String id)
    {
        return m_airportRepository.existsById(id);
    }

    public List<Flight> findFlights(Airport departureAirport, Airport arrivalAirport, LocalDate departureDate)
    {
        return m_flightRepository.findFlights(departureAirport, arrivalAirport, departureDate);
    }

    public Flight flightSave(Flight flight)
    {
        return m_flightRepository.save(flight);
    }

    public Iterable<Flight> flightSaveAll(List<Flight> flights)
    {
        return m_flightRepository.saveAll(flights);
    }

    public long countFlights()
    {
        return m_flightRepository.count();
    }

}
