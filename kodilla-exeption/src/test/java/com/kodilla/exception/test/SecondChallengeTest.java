package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondChallengeTest {

    @Test
    void testShouldNotThrowException() {
        SecondChallenge sc = new SecondChallenge();
        assertDoesNotThrow(() -> sc.probablyIWillThrowException(1.5, 2.0));
    }

    @Test
    void testShouldThrowExceptionForXBelow1() {
        SecondChallenge sc = new SecondChallenge();
        assertThrows(Exception.class, () -> sc.probablyIWillThrowException(0.9, 2.0));
    }

    @Test
    void testShouldThrowExceptionForXEqual2() {
        SecondChallenge sc = new SecondChallenge();
        assertThrows(Exception.class, () -> sc.probablyIWillThrowException(2.0, 2.0));
    }

    @Test
    void testShouldThrowExceptionForYEqual1_5() {
        SecondChallenge sc = new SecondChallenge();
        assertThrows(Exception.class, () -> sc.probablyIWillThrowException(1.5, 1.5));
    }
}
