package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Weather Forecast Test Suite")
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    private WeatherForecast weatherForecast;

    @BeforeEach
    void setup() {

        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @Test
    @DisplayName("Should calculate forecast correctly")
    void testCalculateForecastWithMock() {
        // When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        // Then
        assertEquals(5, quantityOfSensors);
    }

    @Test
    @DisplayName("Should calculate average temperature")
    void testCalculateAverageTemperature() {
        // When
        double averageTemperature = weatherForecast.calculateAverageTemperature();

        // Then
        assertEquals(25.56, averageTemperature, 0.01);
    }

    @Test
    @DisplayName("Should calculate median temperature")
    void testCalculateMedianTemperature() {
        // When
        double medianTemperature = weatherForecast.calculateMedianTemperature();

        // Then
        assertEquals(25.5, medianTemperature, 0.01);
    }
}
