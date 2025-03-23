package com.kodilla.good.patterns.flights;

import java.util.List;
import java.util.Set;

public class FlightApp {
    public static void main(String[] args) {
        FlightRepository repository = new FlightRepository();
        Set<Flight> allFlights = repository.getAllFlights();

        FlightSearchService searchService = new FlightSearchService(allFlights);

        System.out.println("➡️ Flights from GDAŃSK:");
        searchService.findFlightsFrom("GDAŃSK").forEach(System.out::println);

        System.out.println("\n⬅️ Flights to WROCŁAW:");
        searchService.findFlightsTo("WROCŁAW").forEach(System.out::println);

        System.out.println("\n🔁 Flights from GDAŃSK to WROCŁAW through KRAKÓW:");
        searchService.findFlightsThrough("GDAŃSK", "KRAKÓW", "WROCŁAW")
                .forEach(flightChain -> System.out.println(flightChain.get(0) + " -> " + flightChain.get(1)));
    }
}
