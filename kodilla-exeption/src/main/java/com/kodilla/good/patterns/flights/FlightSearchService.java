package com.kodilla.good.patterns.flights;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightSearchService {
    private final Set<Flight> allFlights;

    public FlightSearchService(Set<Flight> allFlights) {
        this.allFlights = allFlights;
    }

    public List<Flight> findFlightsFrom(String city) {
        return allFlights.stream()
                .filter(flight -> flight.getDeparture().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightsTo(String city) {
        return allFlights.stream()
                .filter(flight -> flight.getArrival().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<List<Flight>> findFlightsThrough(String from, String through, String to) {
        return allFlights.stream()
                .filter(f -> f.getDeparture().equalsIgnoreCase(from) && f.getArrival().equalsIgnoreCase(through))
                .flatMap(f1 -> allFlights.stream()
                        .filter(f2 -> f2.getDeparture().equalsIgnoreCase(through) && f2.getArrival().equalsIgnoreCase(to))
                        .map(f2 -> List.of(f1, f2)))
                .collect(Collectors.toList());
    }
}
