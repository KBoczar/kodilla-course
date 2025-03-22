package com.kodilla.rps;

public enum Move {
    ROCK, PAPER, SCISSORS;

    public static Move fromInt(int value) {
        return switch (value) {
            case 1 -> ROCK;
            case 2 -> PAPER;
            case 3 -> SCISSORS;
            default -> throw new IllegalArgumentException("Invalid move number: " + value);
        };
    }
}

