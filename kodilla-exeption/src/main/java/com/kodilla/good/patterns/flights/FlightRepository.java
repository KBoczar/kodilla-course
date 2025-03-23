package com.kodilla.good.patterns.flights;

import java.util.HashSet;
import java.util.Set;

public class FlightRepository {

    public Set<Flight> getAllFlights() {
        Set<Flight> flights = new HashSet<>();
        flights.add(new Flight("GDAŃSK", "WROCŁAW"));
        flights.add(new Flight("GDAŃSK", "KRAKÓW"));
        flights.add(new Flight("KRAKÓW", "WROCŁAW"));
        flights.add(new Flight("WARSZAWA", "GDAŃSK"));
        flights.add(new Flight("WROCŁAW", "POZNAŃ"));
        flights.add(new Flight("POZNAŃ", "KRAKÓW"));
        return flights;
    }
}
