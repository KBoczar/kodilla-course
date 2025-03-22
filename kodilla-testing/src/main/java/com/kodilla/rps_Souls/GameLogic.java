package rps_Souls;

import java.util.Random;

public class GameLogic {
    private final String playerName;
    private final int roundsToWin;
    private final InputHandler inputHandler = new InputHandler();
    private final Random random = new Random();

    private int playerWins = 0;
    private int computerWins = 0;

    public GameLogic(String playerName, int roundsToWin) {
        this.playerName = playerName;
        this.roundsToWin = roundsToWin;
    }

    public void play() {
        while (true) {
            Move playerMove = inputHandler.getPlayerMove();
            if (playerMove == null) {
                if (inputHandler.confirmExit()) break;
                continue;
            }

            Move computerMove = Move.values()[random.nextInt(Move.values().length)];
            System.out.println(playerName + " chose: " + playerMove);
            System.out.println("The Abyss chose: " + computerMove);

            BattleResult result;
            if (playerMove == computerMove) {
                result = BattleResult.DRAW;
                System.out.println("A draw... the flame flickers.");
            } else if (playerMove.beats(computerMove)) {
                result = BattleResult.WIN;
                playerWins++;
                System.out.println("Victory! You conquer the shadow.");
            } else {
                result = BattleResult.LOSE;
                computerWins++;
                System.out.println("Defeat... the Abyss grows.");
            }

            System.out.printf("Score: %s [%d] - Abyss [%d]%n", playerName, playerWins, computerWins);

            if (playerWins >= roundsToWin) {
                System.out.println("\nYou have linked the fire and brought light once more.");
                break;
            } else if (computerWins >= roundsToWin) {
                System.out.println("\nThe darkness prevails. The fire fades...");
                break;
            }
        }
    }
}
