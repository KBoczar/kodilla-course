package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsGame {
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    private String playerName;
    private int roundsToWin;
    private int userWins = 0;
    private int computerWins = 0;

    public void run() {
        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.print("Enter your name: ");
        playerName = scanner.nextLine();

        System.out.print("How many wins are needed to finish the game? ");
        roundsToWin = scanner.nextInt();
        scanner.nextLine(); // clean the newline

        boolean end = false;
        while (!end) {
            System.out.println("\n1 - Rock, 2 - Paper, 3 - Scissors");
            System.out.println("x - Exit game, n - New game");
            System.out.print("Choose your move: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1", "2", "3" -> playRound(Move.fromInt(Integer.parseInt(input)));
                case "x" -> end = confirm("Are you sure you want to exit?");
                case "n" -> {
                    if (confirm("Are you sure you want to start a new game?")) {
                        resetGame();
                    }
                }
                default -> System.out.println("Invalid input!");
            }

            if (userWins == roundsToWin || computerWins == roundsToWin) {
                System.out.println("\nGAME OVER!");
                System.out.println(playerName + " wins: " + userWins);
                System.out.println("Computer wins: " + computerWins);
                end = !confirm("Do you want to play again?");
                if (!end) resetGame();
            }
        }

        System.out.println("Thanks for playing!");
    }

    private void playRound(Move userMove) {
        Move computerMove = Move.fromInt(random.nextInt(3) + 1);
        System.out.println("You played: " + userMove);
        System.out.println("Computer played: " + computerMove);

        RoundResult result = evaluateRound(userMove, computerMove);

        switch (result) {
            case DRAW -> System.out.println("It's a draw!");
            case USER_WIN -> {
                System.out.println("You win this round!");
                userWins++;
            }
            case COMPUTER_WIN -> {
                System.out.println("Computer wins this round!");
                computerWins++;
            }
        }

        System.out.println("Score: " + playerName + " " + userWins + " : " + computerWins + " Computer");
    }

    private RoundResult evaluateRound(Move user, Move computer) {
        if (user == computer) return RoundResult.DRAW;

        return switch (user) {
            case ROCK -> (computer == Move.SCISSORS) ? RoundResult.USER_WIN : RoundResult.COMPUTER_WIN;
            case PAPER -> (computer == Move.ROCK) ? RoundResult.USER_WIN : RoundResult.COMPUTER_WIN;
            case SCISSORS -> (computer == Move.PAPER) ? RoundResult.USER_WIN : RoundResult.COMPUTER_WIN;
        };
    }

    private boolean confirm(String message) {
        System.out.print(message + " (y/n): ");
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    private void resetGame() {
        userWins = 0;
        computerWins = 0;
        System.out.println("Game has been reset.");
    }
}
