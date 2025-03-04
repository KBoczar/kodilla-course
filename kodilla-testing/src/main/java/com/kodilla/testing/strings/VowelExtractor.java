package com.kodilla.testing.strings;

public class VowelExtractor {
    public static String extractVowels(String input) {
        return input.replaceAll("[^AEIOUaeiou]", "");
    }
}
