package com.kodilla.testing;

import com.kodilla.testing.strings.VowelExtractor;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie do testowania oprogramowania");

        // Wypisywanie samogłosek
        String input = "Bernadetta";

        String vowels = VowelExtractor.extractVowels(input);

        System.out.println("Samogłoski w \"" + input + "\": " + vowels);

        // test Simple User
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        // Tworzenie obiektu kalkulatora
        Calculator calculator = new Calculator();

        // Test metody add()
        int sumResult = calculator.add(5, 3);
        if (sumResult == 8) {
            System.out.println("Test add() OK");
        } else {
            System.out.println("Test add() FAILED");
        }

        // Test metody subtract()
        int subtractResult = calculator.subtract(10, 4);
        if (subtractResult == 6) {
            System.out.println("Test subtract() OK");
        } else {
            System.out.println("Test subtract() FAILED");
        }

    }
}
