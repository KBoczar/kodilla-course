package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Starting test...");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("Test finished.");
    }

    @Test
    @DisplayName("Test for empty list")
    void testOddNumbersExterminatorEmptyList() {
        // Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = Arrays.asList();

        // When
        List<Integer> result = exterminator.exterminate(emptyList);

        // Then
        assertTrue(result.isEmpty(), "List should be empty");
    }

    @Test
    @DisplayName("Test for list with even and odd numbers")
    void testOddNumbersExterminatorNormalList() {
        // Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expectedList = Arrays.asList(2, 4, 6, 8, 10);

        // When
        List<Integer> result = exterminator.exterminate(inputList);

        // Then
        assertEquals(expectedList, result, "Even numbers should be filtered correctly");
    }
}
