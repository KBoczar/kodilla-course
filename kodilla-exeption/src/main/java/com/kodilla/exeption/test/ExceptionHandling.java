package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(1.5, 2.0);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}
