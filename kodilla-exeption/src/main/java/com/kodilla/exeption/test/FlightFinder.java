package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> availableFlights = new HashMap<>();
        availableFlights.put("Warsaw", true);
        availableFlights.put("Berlin", false);
        availableFlights.put("London", true);
        availableFlights.put("Tokyo", true);

        Boolean isArrivalAvailable = availableFlights.get(flight.getArrivalAirport());

        if (isArrivalAvailable == null) {
            throw new RouteNotFoundException("Flight to " + flight.getArrivalAirport() + " not found.");
        }

        return isArrivalAvailable;
    }
}
