package com.erbaris.app.flightsearch.data.repository;

import com.erbaris.app.flightsearch.data.entity.Airport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IAirportRepository extends CrudRepository <Airport, String> {
    @Query("select ap from Airport ap where ap.cityName =:name")
    List<Airport> findAirportByCityName(@Param("name") String name);
}
