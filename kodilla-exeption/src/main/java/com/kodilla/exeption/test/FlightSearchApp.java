package com.kodilla.exception.test;

public class FlightSearchApp {
    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();

        Flight flight1 = new Flight("Krakow", "London");
        Flight flight2 = new Flight("Gdansk", "Nowhere"); // Nieistniejące lotnisko

        try {
            boolean canFly1 = flightFinder.findFlight(flight1);
            System.out.println("Flight 1 available: " + canFly1);
        } catch (RouteNotFoundException e) {
            System.out.println("Error while searching flight 1: " + e.getMessage());
        }

        try {
            boolean canFly2 = flightFinder.findFlight(flight2);
            System.out.println("Flight 2 available: " + canFly2);
        } catch (RouteNotFoundException e) {
            System.out.println("Error while searching flight 2: " + e.getMessage());
        }
    }
}
