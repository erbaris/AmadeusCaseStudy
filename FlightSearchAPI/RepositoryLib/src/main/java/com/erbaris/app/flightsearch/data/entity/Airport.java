package com.erbaris.app.flightsearch.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @Column(name = "airport_id")
    public String id;

    @Column(name = "city_name" , nullable = false)
    public String cityName;


    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Airport airport && airport.id == id;
    }

}
