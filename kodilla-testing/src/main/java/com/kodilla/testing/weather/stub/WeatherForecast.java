package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private final Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // Dodajemy 1 stopień
        }
        return resultMap;
    }


    public double calculateAverageTemperature() {
        Map<String, Double> temperatureMap = temperatures.getTemperatures();
        if (temperatureMap.isEmpty()) return 0.0; // Obsługa pustej listy

        double sum = 0;
        for (Double temp : temperatureMap.values()) {
            sum += temp;
        }
        return sum / temperatureMap.size();
    }


    public double calculateMedianTemperature() {
        List<Double> temperatureList = new ArrayList<>(temperatures.getTemperatures().values());
        if (temperatureList.isEmpty()) return 0.0;

        Collections.sort(temperatureList);

        int size = temperatureList.size();
        if (size % 2 == 0) {
            return (temperatureList.get(size / 2 - 1) + temperatureList.get(size / 2)) / 2.0;
        } else {
            return temperatureList.get(size / 2);
        }
    }
}
