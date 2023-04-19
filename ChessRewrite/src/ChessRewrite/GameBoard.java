package ChessRewrite;

import java.util.Arrays;

public class GameBoard {
    private final String[][] grid = new String[8][8];

    public GameBoard() {
        for (String[] strings : grid) {
            Arrays.fill(strings, "~");
        }
    }

    public void setTile(int x, int y, String icon) {
        grid[y][x] = icon;
    }

    public String toString() {
        StringBuilder board = new StringBuilder();
        int i = 8;
        board.append("   _________________\n");
        for (String[] row : grid) {
            board.append(i).append(" | ");
            i--;
            for (String tile : row) {
                board.append(tile).append(" ");
            }
            board.append("|\n");
        }
        board.append("  |_________________|\n\tA B C D E F G H\n");
        return board.toString();
    }
}
