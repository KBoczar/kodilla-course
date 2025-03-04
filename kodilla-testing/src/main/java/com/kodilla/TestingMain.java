package com.kodilla.testing;

import com.kodilla.testing.strings.VowelExtractor;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie do testowania oprogramowania");

        // Wypisywanie samogłosek
        String input = "Bernadetta";

        String vowels = VowelExtractor.extractVowels(input);

        System.out.println("Samogłoski w \"" + input + "\": " + vowels);
    }
}
