package com.erbaris.app.flightsearch.data.repository;

import com.erbaris.app.flightsearch.data.entity.Airport;
import com.erbaris.app.flightsearch.data.entity.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IFlightRepository extends CrudRepository<Flight, Long> {
    @Query("select fl from Flight fl where fl.departureAirport =:departureAirport and fl.destinationAirport =:destinationAirport and fl.departureDate =:departureDate")
    List<Flight> findFlights(@Param("departureAirport") Airport departureAirport,
                                   @Param("destinationAirport") Airport destinationAirport,
                                   @Param("departureDate") LocalDate departureDate);

}
