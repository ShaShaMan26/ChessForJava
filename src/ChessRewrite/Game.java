package ChessRewrite;

import ChessRewrite.Pieces.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.*;
import static java.lang.Math.abs;

public class Game {
    private String actionMessage = "Ex: Move 'D2' to 'D3', 'resign' to end";
    private GameBoard board = new GameBoard();
    private final List<Piece> gamePieces = new ArrayList<>();
    private boolean isWhiteTurn = true;
    private boolean isWon = false;
    private final ScoreBoard scoreBoard = new ScoreBoard();

    public Game() {
        for (int i = 0; i < 16; i++) {
            if (i < 8) {
                gamePieces.add(new Pawn(i, 6, true));
            } else {
                gamePieces.add(new Pawn(i-8, 1, false));
            }
        }
        gamePieces.add(new King(4, 7, true));
        gamePieces.add(new King(4, 0, false));
        gamePieces.add(new Queen(3, 7, true));
        gamePieces.add(new Queen(3, 0, false));
        gamePieces.add(new Rook(0, 7, true));
        gamePieces.add(new Rook(7, 7, true));
        gamePieces.add(new Rook(0, 0, false));
        gamePieces.add(new Rook(7, 0, false));
        gamePieces.add(new Bishop(2, 7, true));
        gamePieces.add(new Bishop(5, 7, true));
        gamePieces.add(new Bishop(2, 0, false));
        gamePieces.add(new Bishop(5, 0, false));
        gamePieces.add(new Knight(1, 7, true));
        gamePieces.add(new Knight(6, 7, true));
        gamePieces.add(new Knight(1, 0, false));
        gamePieces.add(new Knight(6, 0, false));
    }

    public boolean canMakeMove(int startXPos, int startYPos, int endXPos, int endYPos) {
        if (pieceBetween(startXPos, startYPos, endXPos, endYPos)
                || endXPos > 7
                || endXPos < 0
                || endYPos > 7
                || endYPos < 0) {
            return false;
        }

        for (Piece gamePiece : gamePieces) {
            if (gamePiece.at(endXPos, endYPos)
                    && gamePiece.isWhite() == isWhiteTurn) {
                return false;
            }
        }

        for (Piece gamePiece : gamePieces) {
            if (gamePiece.at(startXPos, startYPos)
                    && gamePiece.isWhite() == isWhiteTurn) {
                return gamePiece.canMakeMove(endXPos, endYPos);
            }
        }
        return false;
    }
    public void changeTurnColor() {
        isWhiteTurn = !isWhiteTurn;
    }
    public void displayGame() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        updateBoard();
        System.out.println(actionMessage);
        for (int i = 0; i < 11; i++) {
            System.out.println(board.formatForDisplay().get(i) + " " + scoreBoard.formatForDisplay().get(i));
        }
    }
    public boolean getIsWon() {
        return isWon;
    }
    public void makeMove(int startXPos, int startYPos, int endXPos, int endYPos) throws IOException, InterruptedException {
        for (Piece gamePiece : gamePieces) {
            if (gamePiece.at(startXPos, startYPos)) {
                gamePiece.moveTo(endXPos, endYPos);
                if (gamePiece instanceof Pawn) {
                    if (gamePiece.isWhite() && gamePiece.getYPos() == 0) {
                        displayGame();
                        promote(gamePiece);
                    } else if (!gamePiece.isWhite() && gamePiece.getYPos() == 7) {
                        displayGame();
                        promote(gamePiece);
                    }
                }
            }
        }
    }
    public Boolean pieceBetween(int startX, int startY, int endX, int endY) {
        int delX = endX - startX;
        int delY = endY - startY;
        if (abs(delX) == abs(delY)) {
            for (int i = 1; i < abs(delY); i++) {
                for (Piece gamePiece : gamePieces) {
                    if (gamePiece.at(startX + (signum(delX) * i), (startY + (signum(delY) * i)))) {
                        return true;
                    }
                }
            }
        } else if (delX == 0) {
            for (int i = 1; i < abs(delY); i++) {
                for (Piece gamePiece : gamePieces) {
                    if (gamePiece.at(startX, (startY + (signum(delY) * i)))) {
                        return true;
                    }
                }
            }
        } else if (delY == 0) {
            for (int i = 1; i < abs(delX); i++) {
                for (Piece gamePiece : gamePieces) {
                    if (gamePiece.at(startX + (signum(delX) * i), startY)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void playNextTurn() throws IOException, InterruptedException {
        String startPos = "";
        int startXPos = 0;
        int startYPos = 0;
        String endPos = "";
        int endXPos = 0;
        int endYPos = 0;
        while (true) {
            Scanner moveReader = new Scanner(System.in);
            String turnMessage = "\n";
            if (isWhiteTurn) {
                turnMessage += "White";
            } else {
                turnMessage += "Black";
            }
            turnMessage += "'s move: ";
            System.out.print(turnMessage);
            try {
                startPos = moveReader.next().toUpperCase();
                startXPos = (int) startPos.charAt(0) - 65;
                startYPos = 56 - (int) startPos.charAt(1);
                System.out.print("To: ");
                endPos = moveReader.next().toUpperCase();
                endXPos = (int) endPos.charAt(0) - 65;
                endYPos = 56 - (int) endPos.charAt(1);
            } catch (Exception IOException) {
                if (startPos.trim().equalsIgnoreCase("resign") || endPos.trim().equalsIgnoreCase("resign")) {
                    isWon = true;
                    changeTurnColor();
                    break;
                }
                actionMessage = "INVALID MOVE TRY AGAIN";
                displayGame();
            }

            if (canMakeMove(startXPos, startYPos, endXPos, endYPos)){
                break;
            }

            actionMessage = "INVALID MOVE TRY AGAIN";
            displayGame();
        }
        actionMessage = startPos + " moved to " + endPos;
        takePieceAt(endXPos, endYPos);
        makeMove(startXPos, startYPos, endXPos, endYPos);

        if (isWon) {
            actionMessage = "";
            if (isWhiteTurn) {
                actionMessage += "White";
            } else {
                actionMessage += "Black";
            }
            actionMessage += " won!";
        }

        displayGame();
        changeTurnColor();
    }
    public void promote(Piece gamePiece) throws IOException, InterruptedException {
        String promoteMessage = "Pawn at ";
        promoteMessage += (char)(gamePiece.getXPos() + 65);
        promoteMessage += (8-gamePiece.getYPos());
        promoteMessage += """
                  up for promotion!
                 Promote to:
                 [1] Queen
                 [2] Rook
                 [3] Bishop
                 [4] Knight
                 
                 Enter promotion (num):\s""";

        actionMessage = "Pawn at ";
        actionMessage += (char)(gamePiece.getXPos() + 65);
        actionMessage += (8-gamePiece.getYPos());
        actionMessage += " promoted to ";
        System.out.print(promoteMessage);
        switch (new Scanner(System.in).next().trim()) {
            case "1" -> {
                gamePieces.set(gamePieces.indexOf(gamePiece), new Queen(gamePiece.getXPos(), gamePiece.getYPos(), gamePiece.isWhite()));
                actionMessage += "Queen";
            }
            case "2" -> {
                gamePieces.set(gamePieces.indexOf(gamePiece), new Rook(gamePiece.getXPos(), gamePiece.getYPos(), gamePiece.isWhite()));
                actionMessage += "Rook";
            }
            case "3" -> {
                gamePieces.set(gamePieces.indexOf(gamePiece), new Bishop(gamePiece.getXPos(), gamePiece.getYPos(), gamePiece.isWhite()));
                actionMessage += "Bishop";
            }
            case "4" -> {
                gamePieces.set(gamePieces.indexOf(gamePiece), new Knight(gamePiece.getXPos(), gamePiece.getYPos(), gamePiece.isWhite()));
                actionMessage += "Knight";
            }
            default -> {
                actionMessage = "INVALID PROMOTION TRY AGAIN";
                displayGame();
                promote(gamePiece);
            }
        }
        gamePiece.setXYPos(-2, -2);

    }
    public void takePieceAt(int x, int y) {
        for (Piece gamePiece : gamePieces) {
            if (gamePiece.at(x, y)
                && gamePiece.isWhite() != isWhiteTurn) {
                gamePiece.moveTo(-1, -1);
                scoreBoard.addToScoreBoard(gamePiece);
                if (gamePiece instanceof King) {
                    isWon = true;
                }
            }
        }
    }
    public void updateBoard() {
        board = new GameBoard();
        for (Piece piece : gamePieces) {
            if (piece.getXPos() > -1) {
                board.setTile(piece.getXPos(), piece.getYPos(), piece.getIcon());
            }

            if (piece instanceof Pawn) {
                ((Pawn) piece).setIsDiagonalOfPiece(pieceBetween(piece.getXPos(), piece.getYPos(),
                        piece.getXPos() + (piece.getColorMod() * 2), piece.getYPos() - (piece.getColorMod() * 2))
                        || pieceBetween(piece.getXPos(), piece.getYPos(),
                        piece.getXPos() - (piece.getColorMod() * 2), piece.getYPos() - (piece.getColorMod() * 2)));
                ((Pawn) piece).setIsInFrontOfPiece(pieceBetween(piece.getXPos(), piece.getYPos(),
                        piece.getXPos(), piece.getYPos() - (piece.getColorMod() * 2)));
            }
        }
    }
}
