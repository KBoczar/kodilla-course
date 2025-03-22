package com.kodilla.good.patterns.challenges;

public class FactorialMain {
    public static void main(String[] args) {
        int n = 5;

        long result = FactorialCalculator.factorial(n);
        long recursive = FactorialCalculator.factorialRecursive(n);

        System.out.println(n + "! (iterative) = " + result);
        System.out.println(n + "! (recursive) = " + recursive);
    }
}
