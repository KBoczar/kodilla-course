package rps_Souls;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public String getPlayerName() {
        System.out.print("Unkindled One, reveal your name: ");
        return scanner.nextLine();
    }

    public int getRoundsToWin() {
        System.out.print("How many victories will it take to link the flame? ");
        return scanner.nextInt();
    }

    public Move getPlayerMove() {
        System.out.println("""
            Choose your move:
            1 – Sword
            2 – Magic
            3 – Shield
            4 – Pyromancy
            5 – Estus Flask
            x – Exit game
            n – New game
            """);
        String input = scanner.next();
        return switch (input) {
            case "1" -> Move.SWORD;
            case "2" -> Move.MAGIC;
            case "3" -> Move.SHIELD;
            case "4" -> Move.PYROMANCY;
            case "5" -> Move.ESTUS_FLASK;
            case "x" -> null;
            case "n" -> null;
            default -> {
                System.out.println("Invalid move.");
                yield getPlayerMove();
            }
        };
    }

    public boolean confirmExit() {
        System.out.print("Are you sure you want to abandon your fate? (y/n): ");
        return scanner.next().equalsIgnoreCase("y");
    }

    public boolean confirmRestart() {
        System.out.print("Do you wish to begin a new pilgrimage? (y/n): ");
        return scanner.next().equalsIgnoreCase("y");
    }
}
