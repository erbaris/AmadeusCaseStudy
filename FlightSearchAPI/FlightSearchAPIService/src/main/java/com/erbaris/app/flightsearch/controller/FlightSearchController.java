package com.erbaris.app.flightsearch.controller;


import com.erbaris.app.flightsearch.data.entity.Airport;
import com.erbaris.app.flightsearch.data.entity.Flight;
import com.erbaris.app.flightsearch.random.RandomAirportGenerator;
import com.erbaris.app.flightsearch.random.RandomFlightGenerator;
import com.erbaris.app.flightsearch.service.FlightSearchAppService;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;
import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("api/flightsearch")
public class FlightSearchController {
    private final FlightSearchAppService m_flightSearchAppService;
    private final RandomAirportGenerator m_randomAirportGenerator;
    private final RandomFlightGenerator m_randomFlightGenerator;

    public FlightSearchController(FlightSearchAppService flightSearchAppService, RandomAirportGenerator randomAirportGenerator, RandomFlightGenerator randomFlightGenerator) {
        m_flightSearchAppService = flightSearchAppService;
        m_randomAirportGenerator = randomAirportGenerator;
        m_randomFlightGenerator = randomFlightGenerator;
    }

    @GetMapping("find/flights")
    public List<Flight> findFlights(String departureAirportId, String destinationAirportId, String departureDate,@Nullable String returnDate)
    {
        String[] departureDateStr = departureDate.split("[-]+");
        var departureLocalDate = LocalDate.of(Integer.parseInt(departureDateStr[0]), Integer.parseInt(departureDateStr[1]), Integer.parseInt(departureDateStr[2]));

        LocalDate returnLocalDate = null;
        if(returnDate != null){
            var returnDateStr = returnDate.split("[-]+");
            returnLocalDate = LocalDate.of(Integer.parseInt(returnDateStr[0]), Integer.parseInt(returnDateStr[1]), Integer.parseInt(returnDateStr[2]));
        }

        return m_flightSearchAppService.findAllFlightsByAirportId(departureAirportId, destinationAirportId, departureLocalDate, returnLocalDate );
    }


    @GetMapping("find/airport")
    public List<Airport> findAirport(String cityName)
    {
        return m_flightSearchAppService.findAirportByCityName(cityName);
    }

    @PostMapping("save/flight")
    public Flight saveFlight(Flight flight)
    {
        return m_flightSearchAppService.flightSave(flight);
    }

    @GetMapping("random/randomflightsave")
    public Flight genereteRandomFlightAndSave()
    {
        return m_randomFlightGenerator.getRandomFlightandSave(m_flightSearchAppService);
    }
    @GetMapping("random/airport")
    public Airport genereteRandomAirport()
    {
        return m_randomAirportGenerator.getRandomAirport(m_flightSearchAppService);
    }
    @GetMapping("flightquantity")
    public long countFlights()
    {
        return m_flightSearchAppService.countFlights();
    }

}
