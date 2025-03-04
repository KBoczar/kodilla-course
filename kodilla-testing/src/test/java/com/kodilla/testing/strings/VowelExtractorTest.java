package com.kodilla.testing.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VowelExtractorTest {
    @Test
    public void testExtractVowels() {
        // Given
        String input = "Adam";

        // When
        String result = VowelExtractor.extractVowels(input);

        // Then
        assertEquals("Aa", result);
    }
}
