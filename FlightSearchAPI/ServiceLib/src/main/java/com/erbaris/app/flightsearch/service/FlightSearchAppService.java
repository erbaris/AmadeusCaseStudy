package com.erbaris.app.flightsearch.service;

import com.erbaris.app.flightsearch.data.dal.FlightSearchAppHelper;
import com.erbaris.app.flightsearch.data.entity.Airport;
import com.erbaris.app.flightsearch.data.entity.Flight;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Scope("prototype")
public class FlightSearchAppService {
    private final FlightSearchAppHelper m_flightSearchAppHelper;

    public FlightSearchAppService(FlightSearchAppHelper flightSearchAppHelper) {
        m_flightSearchAppHelper = flightSearchAppHelper;
    }

    public List<Flight> findAllFlights(Airport departureAirport, Airport arrivalAirport, LocalDate departureDate, LocalDate returnDate)
    {
        if (returnDate == null)
            return findFlights(departureAirport, arrivalAirport, departureDate);
        else {
            ArrayList<Flight> flights = new ArrayList<>();
            flights.addAll(findFlights(departureAirport, arrivalAirport, departureDate));
            flights.addAll(findFlights(arrivalAirport, departureAirport, returnDate));
            return flights;
        }
    }
    public List<Flight> findFlights(Airport departureAirport, Airport arrivalAirport, LocalDate departureDate)
    {
        return m_flightSearchAppHelper.findFlights(departureAirport, arrivalAirport, departureDate);
    }
    public List<Flight> findAllFlightsByAirportId(String departureAirportId, String arrivalAirportId, LocalDate departureDate, LocalDate returnDate)
    {
        Optional<Airport> departureAirport = m_flightSearchAppHelper.findAirportById(departureAirportId);
        Optional<Airport> arrivalAirport = m_flightSearchAppHelper.findAirportById(arrivalAirportId);

        if (departureAirport.isPresent() && arrivalAirport.isPresent())
            return findAllFlights(departureAirport.get(), arrivalAirport.get(), departureDate, returnDate);
        else
            return new ArrayList<>();

    }
    public List<Flight> findAllFlightsByAirportId(String departureAirportId, String arrivalAirportId, LocalDate departureDate)
    {
        return findAllFlightsByAirportId(departureAirportId, arrivalAirportId, departureDate, null);
    }
    public List<Airport> findAirportByCityName(String cityName)
    {
        return m_flightSearchAppHelper.findAirportByName(cityName);
    }

    public boolean airportExistById(String id)
    {
        return m_flightSearchAppHelper.airportExistById(id);
    }
    public Airport getAirportById(String id)
    {
        return m_flightSearchAppHelper.findAirportById(id).isPresent() ? m_flightSearchAppHelper.findAirportById(id).get() : null;
    }

    public Flight flightSave(Flight flight)
    {
        return m_flightSearchAppHelper.flightSave(flight);
    }

    public Iterable<Flight> flightSaveAll(List<Flight> flights)
    {
        return m_flightSearchAppHelper.flightSaveAll(flights);
    }

    public long countFlights()
    {
        return m_flightSearchAppHelper.countFlights();
    }
}
