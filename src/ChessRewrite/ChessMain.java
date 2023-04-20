package ChessRewrite;

import java.io.IOException;
import java.util.Scanner;
public class ChessMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner inputReader = new Scanner(System.in);
        do {
            Game currentGame = new Game();

            currentGame.displayGame();

            while (!currentGame.getIsWon()) {
                currentGame.playNextTurn();
            }

            System.out.print("\nNew game? (y/n): ");
        } while (inputReader.next().trim().equalsIgnoreCase("y"));
    }
}
