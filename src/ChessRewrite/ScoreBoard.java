package ChessRewrite;

import ChessRewrite.Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private final List<String> whiteGrid = new ArrayList<>();
    private final List<String> blackGrid = new ArrayList<>();
    public ScoreBoard() {
        for (int i = 0; i < 18; i++) {
            whiteGrid.add("~");
            blackGrid.add("~");
        }
    }

    public void addToScoreBoard(Piece gamePiece) {
        if (gamePiece.isWhite()) {
            blackGrid.add(0, gamePiece.getIcon());
        } else {
            whiteGrid.add(0, gamePiece.getIcon());
        }
    }
    public void updateBoard() {
        while (whiteGrid.size() > 18) {
            whiteGrid.remove(whiteGrid.size()-1);
        }
        while (blackGrid.size() > 18) {
            blackGrid.remove(blackGrid.size()-1);
        }
    }

    public List<String> formatForDisplay() {
        updateBoard();
        List<String> board = new ArrayList<>();
        board.add("");
        board.add(" White | Black ");
        board.add("---------------");
        List<String> tempWhiteGrid = new ArrayList<>(whiteGrid);
        List<String> tempBlackGrid = new ArrayList<>(blackGrid);
        for (int i = 0; i < 6; i++) {
            StringBuilder tempStr = new StringBuilder();
            tempStr.append(" ");
            for (int j = 0; j < 3; j++) {
                tempStr.append(tempWhiteGrid.remove(0)).append(" ");
            }
            tempStr.append("| ");
            for (int j = 0; j < 3; j++) {
                tempStr.append(tempBlackGrid.remove(0)).append(" ");
            }
            board.add(tempStr.toString());
        }
        for (int i = 0; i < 2; i++) {
            board.add("");
        }

        return board;
    }
}
