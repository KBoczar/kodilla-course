package rps_Souls;

import java.util.Scanner;

public class RpsSoulsRunner {

    public static void main(String[] args) {
        printIntro();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ashen One, what is your name? ");
        String playerName = scanner.nextLine();

        System.out.print("How many victories are needed to link the flame, " + playerName + "? ");
        int roundsToWin = Integer.parseInt(scanner.nextLine());

        GameLogic game = new GameLogic(playerName, roundsToWin);
        game.play();
    }

    private static void printIntro() {
        System.out.println("===============================================");
        System.out.println("         DARK SOULS: ASHES OF RPS");
        System.out.println("===============================================");
        System.out.println("In the fading lands of Lordran, the Flame grows weak.");
        System.out.println("You, an Ashen One, have awoken once more.");
        System.out.println("To rekindle the fire, you must triumph in ritual combat.");
        System.out.println("Choose your weapon wisely, for each has its strengths...");
        System.out.println();
        System.out.println("Combat Arts:");
        System.out.println("1 - Sword        (Beats Magic & Estus Flask)");
        System.out.println("2 - Pyromancy    (Burns Shield & Sword)");
        System.out.println("3 - Magic        (Pierces Shield & Pyromancy)");
        System.out.println("4 - Shield       (Blocks Sword & Estus Flask)");
        System.out.println("5 - Estus Flask  (Outlasts Pyromancy & Magic)");
        System.out.println();
        System.out.println("x - End game");
        System.out.println("n - New game");
        System.out.println("===============================================");
    }
}
