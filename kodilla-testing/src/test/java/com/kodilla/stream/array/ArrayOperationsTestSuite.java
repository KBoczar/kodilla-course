package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        // Given
        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
                110, 120, 130, 140, 150, 160, 170, 180, 190, 200};

        // When
        double average = ArrayOperations.getAverage(numbers);

        // Then
        assertEquals(105.0, average, 0.001);
    }
}
