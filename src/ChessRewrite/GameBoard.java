package ChessRewrite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<String> formatForDisplay() {
        List<String> board = new ArrayList<>();
        int i = 8;
        board.add("   _________________");
        for (String[] row : grid) {
            StringBuilder tempStr = new StringBuilder();
            tempStr.append(i).append(" | ");
            i--;
            for (String tile : row) {
                tempStr.append(tile).append(" ");
            }
            tempStr.append("|");
            board.add(tempStr.toString());
        }
        board.add("  |_________________|");
        board.add("\tA B C D E F G H");

        return board;
    }
}
