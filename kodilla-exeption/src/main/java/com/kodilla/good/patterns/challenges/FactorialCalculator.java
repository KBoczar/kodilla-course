package com.kodilla.good.patterns.challenges;

public class FactorialCalculator {

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be a natural number (0 or positive).");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public static long factorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be a natural number (0 or positive).");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }
}
