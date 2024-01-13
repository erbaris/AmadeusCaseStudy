package com.erbaris.app.flightsearch.data.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    public long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_airport", nullable = false)
    public Airport departureAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_airport", nullable = false)
    public Airport destinationAirport;

    @Column(name = "departure_date", nullable = false)
    public LocalDate departureDate;

    @Column(name = "departure_time", nullable = false)
    public LocalTime departureTime;

    @Column(name = "ticket_price", nullable = false)
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

}
