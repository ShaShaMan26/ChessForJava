import java.util.*;
import java.io.IOException;

public class Chess {
    // initializes iteration vars
    public static int i, j, g, r, c;

    // initializes game vars
    public static boolean gameOn, promotion;
    public static int vOffset, hOffset, promotionIndex;

    // initializes player variables
    public static String p1Name, p2Name;
    public static boolean p1Win, p2Win;

    // initalizes actionMessage
    public static String actionMessage;

    // initializes gameBoard
    public static String[] row1 = new String[8];
    public static String[] row2 = new String[8];
    public static String[] row3 = new String[8];
    public static String[] row4 = new String[8];
    public static String[] row5 = new String[8];
    public static String[] row6 = new String[8];
    public static String[] row7 = new String[8];
    public static String[] row8 = new String[8];
    public static String[][] gameBoard = { row1, row2, row3, row4, row5, row6, row7, row8 };

    // initializes board
    public static String board[] = new String[12];

    // initializes scoreBoard
    public static String scoreBoard[] = new String[10];

    // initializes player score vars
    public static String[] whiteTakenPieces = new String[16];
    public static int whiteTakenIndex = 0;
    public static String[] blackTakenPieces = new String[16];
    public static int blackTakenIndex = 0;

    // initializes move vars
    public static String startPos, endPos;
    public static int startCol, startRow, endCol, endRow;

    // initializes pieces

    // pawns
    // White
    public static Pawn whitePawn1 = new Pawn(6, 0, true, "P");
    public static Pawn whitePawn2 = new Pawn(6, 1, true, "P");
    public static Pawn whitePawn3 = new Pawn(6, 2, true, "P");
    public static Pawn whitePawn4 = new Pawn(6, 3, true, "P");
    public static Pawn whitePawn5 = new Pawn(6, 4, true, "P");
    public static Pawn whitePawn6 = new Pawn(6, 5, true, "P");
    public static Pawn whitePawn7 = new Pawn(6, 6, true, "P");
    public static Pawn whitePawn8 = new Pawn(6, 7, true, "P");
    // Black
    public static Pawn blackPawn1 = new Pawn(1, 0, false, "p");
    public static Pawn blackPawn2 = new Pawn(1, 1, false, "p");
    public static Pawn blackPawn3 = new Pawn(1, 2, false, "p");
    public static Pawn blackPawn4 = new Pawn(1, 3, false, "p");
    public static Pawn blackPawn5 = new Pawn(1, 4, false, "p");
    public static Pawn blackPawn6 = new Pawn(1, 5, false, "p");
    public static Pawn blackPawn7 = new Pawn(1, 6, false, "p");
    public static Pawn blackPawn8 = new Pawn(1, 7, false, "p");
    // creates a pawn array
    public static Pawn[] Pawns = { whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7,
            whitePawn8,
            blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8 };

    // knights
    // White
    public static Knight whiteKnight1 = new Knight(7, 1, true, "N");
    public static Knight whiteKnight2 = new Knight(7, 6, true, "N");
    // Black
    public static Knight blackKnight1 = new Knight(0, 1, false, "n");
    public static Knight blackKnight2 = new Knight(0, 6, false, "n");
    // creates a knight array
    public static Knight[] Knights = { whiteKnight1, whiteKnight2,
            blackKnight1, blackKnight2 };

    // rooks
    // white
    public static Rook whiteRook1 = new Rook(7, 0, true, "R");
    public static Rook whiteRook2 = new Rook(7, 7, true, "R");
    // black
    public static Rook blackRook1 = new Rook(0, 0, false, "r");
    public static Rook blackRook2 = new Rook(0, 7, false, "r");
    // creates a rook array
    public static Rook[] Rooks = { whiteRook1, whiteRook2,
            blackRook1, blackRook2 };

    // bishops
    // white
    public static Bishop whiteBishop1 = new Bishop(7, 2, true, "B");
    public static Bishop whiteBishop2 = new Bishop(7, 5, true, "B");
    // black
    public static Bishop blackBishop1 = new Bishop(0, 2, false, "b");
    public static Bishop blackBishop2 = new Bishop(0, 5, false, "b");
    // creates a bishop array
    public static Bishop[] Bishops = { whiteBishop1, whiteBishop2,
            blackBishop1, blackBishop2 };

    // queens
    // white
    public static Queen whiteQueen = new Queen(7, 3, true, "Q");
    // black
    public static Queen blackQueen = new Queen(0, 3, false, "q");
    // creates a queen array
    public static Queen[] Queens = { whiteQueen,
            blackQueen };

    // kings
    // white
    public static King whiteKing = new King(7, 4, true, "K");
    // black
    public static King blackKing = new King(0, 4, false, "k");
    // creates a king array
    public static King[] Kings = { whiteKing,
            blackKing };

    public static void main(String args[]) throws IOException, InterruptedException {

        // program loop
        while (true) {
            // resets pieces
            // pawns
            // White
            for (i = 0; i < 8; i++) {
                Pawns[i].row = 6;
                Pawns[i].col = i;
                Pawns[i].icon = "P";
            }
            // Black
            for (i = 8; i < 16; i++) {
                Pawns[i].row = 1;
                Pawns[i].col = Math.abs(i - 8);
                Pawns[i].icon = "p";
            }

            // knights
            // White
            whiteKnight1.row = 7;
            whiteKnight1.col = 1;
            whiteKnight2.row = 7;
            whiteKnight2.col = 6;
            // Black
            blackKnight1.row = 0;
            blackKnight1.col = 1;
            blackKnight2.row = 0;
            blackKnight2.col = 6;

            // rooks
            // White
            whiteRook1.row = 7;
            whiteRook1.col = 0;
            whiteRook2.row = 7;
            whiteRook2.col = 7;
            // Black
            blackRook1.row = 0;
            blackRook1.col = 0;
            blackRook2.row = 0;
            blackRook2.col = 7;

            // bishops
            // White
            whiteBishop1.row = 7;
            whiteBishop1.col = 2;
            whiteBishop2.row = 7;
            whiteBishop2.col = 5;
            // Black
            blackBishop1.row = 0;
            blackBishop1.col = 2;
            blackBishop2.row = 0;
            blackBishop2.col = 5;

            // queens
            // white
            whiteQueen.row = 7;
            whiteQueen.col = 3;
            // black
            blackQueen.row = 0;
            blackQueen.col = 3;

            // kings
            // white
            whiteKing.row = 7;
            whiteKing.col = 4;
            // black
            blackKing.row = 0;
            blackKing.col = 4;

            // reset vars
            p1Win = false;
            p2Win = false;
            gameOn = true;
            actionMessage = "Ex: Move 'A1' to 'A2', 'resign' to end";

            // populates taken pieces with blanks rather than nulls
            for (i = 0; i < 16; i++) {
                whiteTakenPieces[i] = " ";
                blackTakenPieces[i] = " ";
            }

            // options
            Scanner input = new Scanner(System.in);
            System.out.print("Player 1 Name: ");
            p1Name = input.next().trim();
            System.out.print("Player 2 Name: ");
            p2Name = input.next().trim();
            System.out.print("Vertical Offset: ");
            try {
                vOffset = input.nextInt();
            } catch (Exception IOException) {
                input.next();
                vOffset = 0;
            }
            System.out.print("Horizontal Offset: ");
            try {
                hOffset = input.nextInt();
            } catch (Exception IOException) {
                input.next();
                hOffset = 0;
            }

            // game loop
            while (gameOn) {
                // renders frame
                render();

                // checks for and preforms promotion
                if (promotion && (!p1Win || !p2Win)) {
                    performPromotion();
                }

                // White turn
                while (!makeMove(p1Name, "w")) {
                    render();
                }

                // renders frame
                render();

                // checks for and preforms promotion
                if (promotion && (!p1Win || !p2Win)) {
                    performPromotion();
                }

                // Black turn
                while (!makeMove(p2Name, "b")) {
                    render();
                }
            }

            System.out.println();
            // adds horizontal offset
            for (i = 0; i < hOffset; i++) {
                System.out.print(" ");
            }
            System.out.print("  Play again? (y/n): ");
            if (!input.next().trim().toLowerCase().equals("y")) {
                break;
            }

            // clears terminal
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // stolen from
                                                                                  // https://rootstack.com/en/blog/java-clear-screen
        }
    }

    public static void render() throws IOException, InterruptedException {
        /*
         * Renders board.
         */

        // resets gameBoard
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                gameBoard[i][j] = "~";
            }
        }
        // resets board
        for (i = 0; i < 12; i++) {
            board[i] = "";
        }
        // resets scoreBoard
        for (i = 0; i < 10; i++) {
            scoreBoard[i] = "";
        }

        // populates gameBoard
        // pawns
        for (i = 0; i < 16; i++) {
            if ((Pawns[i].row < 8 && Pawns[i].row > -1) && (Pawns[i].col < 8 && Pawns[i].col > -1)) {
                gameBoard[Pawns[i].row][Pawns[i].col] = Pawns[i].icon;
            }
        }
        // knights
        for (i = 0; i < 4; i++) {
            if ((Knights[i].row < 8 && Knights[i].row > -1) && (Knights[i].col < 8 && Knights[i].col > -1)) {
                gameBoard[Knights[i].row][Knights[i].col] = Knights[i].icon;
            }
        }
        // rooks
        for (i = 0; i < 4; i++) {
            if ((Rooks[i].row < 8 && Rooks[i].row > -1) && (Rooks[i].col < 8 && Rooks[i].col > -1)) {
                gameBoard[Rooks[i].row][Rooks[i].col] = Rooks[i].icon;
            }
        }
        // bishops
        for (i = 0; i < 4; i++) {
            if ((Bishops[i].row < 8 && Bishops[i].row > -1) && (Bishops[i].col < 8 && Bishops[i].col > -1)) {
                gameBoard[Bishops[i].row][Bishops[i].col] = Bishops[i].icon;
            }
        }
        // queens
        for (i = 0; i < 2; i++) {
            if ((Queens[i].row < 8 && Queens[i].row > -1) && (Queens[i].col < 8 && Queens[i].col > -1)) {
                gameBoard[Queens[i].row][Queens[i].col] = Queens[i].icon;
            }
        }
        // kings
        for (i = 0; i < 2; i++) {
            if ((Kings[i].row < 8 && Kings[i].row > -1) && (Kings[i].col < 8 && Kings[i].col > -1)) {
                gameBoard[Kings[i].row][Kings[i].col] = Kings[i].icon;
            }
        }

        // generates board
        g = 0;
        r = 0;
        c = 0;
        for (i = 0; i < 12; i++) {
            for (j = 0; j < 22; j++) {
                // top and bottom
                if (i == 0) {
                    if (j < 2 || j > 20) {
                        board[i] += " ";
                    } else {
                        board[i] += "_";
                    }
                } else if (i == 1 || i == 10) {
                    if (j == 1 || j == 21) {
                        board[i] += "|";
                    } else {
                        if (i == 10 && j > 1) {
                            board[i] += "_";
                        } else {
                            board[i] += " ";
                        }
                    }
                    // middle
                } else if (i > 1 && i < 10) {
                    if (j == 0) {
                        board[i] += "" + (10 - i);
                    } else if (j == 1 || j == 21) {
                        board[i] += "|";
                    } else if (j < 4 || j > 18) {
                        board[i] += " ";
                    } else if (j % 2 == 0) {
                        board[i] += gameBoard[r][c];
                        if (c < 7) {
                            c++;
                        }
                    } else {
                        board[i] += " ";
                    }
                    // lettering
                } else {
                    if ((j > 3 && j < 20) && (j % 2 == 0)) {
                        board[i] += (char) (65 + g);
                        g++;
                    } else {
                        board[i] += " ";
                    }
                }
            }
            if (i > 1) {
                r++;
            }
            c = 0;
        }

        // generates score board
        g = 0;
        c = 0;
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 13; j++) {
                if (i == 0) {
                    if (j == 2 || j == 9) {
                        scoreBoard[i] += "p";
                    } else if (j == 3) {
                        scoreBoard[i] += "1";
                    } else if (j == 10) {
                        scoreBoard[i] += "2";
                    } else if (j == 6) {
                        scoreBoard[i] += "|";
                    } else {
                        scoreBoard[i] += " ";
                    }
                } else if (i == 1) {
                    scoreBoard[i] += "-";
                } else {
                    if (j == 6) {
                        scoreBoard[i] += "|";
                    } else if (j == 1 || j == 4) {
                        scoreBoard[i] += blackTakenPieces[g];
                        g++;
                    } else if (j == 8 || j == 11) {
                        scoreBoard[i] += whiteTakenPieces[c];
                        c++;
                    } else {
                        scoreBoard[i] += " ";
                    }
                }
            }
        }

        // clears terminal
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // stolen from
                                                                              // https://rootstack.com/en/blog/java-clear-screen

        // adds vertical offset
        for (i = 0; i < vOffset; i++) {
            System.out.println("");
        }

        // adds horizontal offset
        for (i = 0; i < hOffset; i++) {
            System.out.print(" ");
        }

        // displays action message
        System.out.println(" " + actionMessage);

        // displays board and scoreBoard with horizontal offset
        for (i = 0; i < 12; i++) {
            for (j = 0; j < hOffset; j++) {
                System.out.print(" ");
            }
            System.out.print(board[i]);
            if (i > 0 && i < 11) {
                System.out.print("\t" + scoreBoard[i - 1]);
            }
            System.out.println();
        }
    }

    public static boolean makeMove(String name, String isWhite) throws IOException, InterruptedException {
        /*
         * Prompts user input for move to make, clears terminal, validates move, prints
         * result.
         */

        // checks to see if game has been won and displays appropriate message
        if (p1Win) {
            System.out.println();
            // adds horizontal offset
            for (i = 0; i < hOffset; i++) {
                System.out.print(" ");
            }
            System.out.print("  " + p1Name + " wins!");
            gameOn = false;
            return true;
        } else if (p2Win) {
            System.out.println();
            // adds horizontal offset
            for (i = 0; i < hOffset; i++) {
                System.out.print(" ");
            }
            System.out.print("  " + p2Name + " wins!");
            gameOn = false;
            return true;
        }

        Scanner input = new Scanner(System.in);

        System.out.println();

        // adds horizontal offset
        for (i = 0; i < hOffset; i++) {
            System.out.print(" ");
        }

        System.out.print("  " + name + "'s move: ");
        try {
            // define starting position values

            // checks for resignation
            startPos = input.next();
            if (startPos.trim().toLowerCase().equals("resign")) {
                if (name.equals(p1Name)) {
                    p2Win = true;
                } else if (name.equals(p2Name)) {
                    p1Win = true;
                }
                actionMessage = " " + name + " resigned.";
                return false;
            }

            startRow = 56 - (int) startPos.charAt(1);
            startCol = (int) startPos.charAt(0) - 65;
            // adds horizontal offset
            for (i = 0; i < hOffset; i++) {
                System.out.print(" ");
            }
            System.out.print("    To ");
            // define end position values
            endPos = input.next();
            endRow = 56 - (int) endPos.charAt(1);
            endCol = (int) endPos.charAt(0) - 65;
        } catch (Exception IOException) {
            actionMessage = " Invalid move.";
            return false;
        }
        // attempt move
        if (validateMove(startRow, startCol, endRow, endCol, isWhite)) {
            actionMessage = " " + (char) (startCol + 65) + (8 - startRow) + " moved to " + (char) (endCol + 65)
                    + (8 - endRow) + ".";
            return true;
        } else {
            actionMessage = " Invalid move.";
            return false;
        }
    }

    public static boolean validateMove(int sR, int sC, int eR, int eC, String isW) {
        /*
         * Identifies piece at start location and moves piece to end location if valid.
         * Promotes piece when applicable.
         */

        if ((eR < 8 && eR > -1) && (eC < 8 && eC > -1) && gameBoard[sR][sC] != "~") {
            if (pieceColorAt(eR, eC).equals(isW)) {
                return false;
            }
            if (isW.equals("w")) {
                // pawns
                for (i = 0; i < 8; i++) {
                    if (Pawns[i].row == sR && Pawns[i].col == sC) {
                        if (eR == 0 && !Pawns[i].hasPromoted) {
                            promotion = true;
                            promotionIndex = i;
                        }
                        return Pawns[i].move(eR, eC);
                    }
                }
                // knights
                for (i = 0; i < 2; i++) {
                    if (Knights[i].row == sR && Knights[i].col == sC) {
                        return Knights[i].move(eR, eC);
                    }
                }
                // rooks
                for (i = 0; i < 2; i++) {
                    if (Rooks[i].row == sR && Rooks[i].col == sC) {
                        return Rooks[i].move(eR, eC);
                    }
                }
                // bishops
                for (i = 0; i < 2; i++) {
                    if (Bishops[i].row == sR && Bishops[i].col == sC) {
                        return Bishops[i].move(eR, eC);
                    }
                }
                // queen
                for (i = 0; i < 1; i++) {
                    if (Queens[i].row == sR && Queens[i].col == sC) {
                        return Queens[i].move(eR, eC);
                    }
                }
                // king
                for (i = 0; i < 1; i++) {
                    if (Kings[i].row == sR && Kings[i].col == sC) {
                        return Kings[i].move(eR, eC);
                    }
                }
                return false;
            } else if (isW.equals("b")) {
                // pawns
                for (i = 8; i < 16; i++) {
                    if (Pawns[i].row == sR && Pawns[i].col == sC) {
                        if (eR == 7 && !Pawns[i].hasPromoted) {
                            promotion = true;
                            promotionIndex = (i + 8);
                        }
                        return Pawns[i].move(eR, eC);
                    }
                }
                // knights
                for (i = 2; i < 4; i++) {
                    if (Knights[i].row == sR && Knights[i].col == sC) {
                        return Knights[i].move(eR, eC);
                    }
                }
                // rooks
                for (i = 2; i < 4; i++) {
                    if (Rooks[i].row == sR && Rooks[i].col == sC) {
                        return Rooks[i].move(eR, eC);
                    }
                }
                // bishops
                for (i = 2; i < 4; i++) {
                    if (Bishops[i].row == sR && Bishops[i].col == sC) {
                        return Bishops[i].move(eR, eC);
                    }
                }
                // queen
                for (i = 1; i < 2; i++) {
                    if (Queens[i].row == sR && Queens[i].col == sC) {
                        return Queens[i].move(eR, eC);
                    }
                }
                // king
                for (i = 1; i < 2; i++) {
                    if (Kings[i].row == sR && Kings[i].col == sC) {
                        return Kings[i].move(eR, eC);
                    }
                }
                return false;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean pieceAt(int r, int c) {
        /*
         * Finds if there is a piece on a specific place on the gameBoard
         */

        // pawns
        for (i = 0; i < 16; i++) {
            if (Pawns[i].row == r && Pawns[i].col == c) {
                return true;
            }
        }
        // knights
        for (i = 0; i < 4; i++) {
            if (Knights[i].row == r && Knights[i].col == c) {
                return true;
            }
        }
        // rooks
        for (i = 0; i < 4; i++) {
            if (Rooks[i].row == r && Rooks[i].col == c) {
                return true;
            }
        }
        // bishops
        for (i = 0; i < 4; i++) {
            if (Bishops[i].row == r && Bishops[i].col == c) {
                return true;
            }
        }
        // queens
        for (i = 0; i < 2; i++) {
            if (Queens[i].row == r && Queens[i].col == c) {
                return true;
            }
        }
        // kings
        for (i = 0; i < 2; i++) {
            if (Kings[i].row == r && Kings[i].col == c) {
                return true;
            }
        }

        // if no piece is found
        return false;
    }

    public static String pieceColorAt(int r, int c) {
        /*
         * Finds color of piece at location
         */

        // white pieces
        // pawns
        for (i = 0; i < 8; i++) {
            if (Pawns[i].row == r && Pawns[i].col == c) {
                return "w";
            }
        }
        // knights
        for (i = 0; i < 2; i++) {
            if (Knights[i].row == r && Knights[i].col == c) {
                return "w";
            }
        }
        // rooks
        for (i = 0; i < 2; i++) {
            if (Rooks[i].row == r && Rooks[i].col == c) {
                return "w";
            }
        }
        // bishops
        for (i = 0; i < 2; i++) {
            if (Bishops[i].row == r && Bishops[i].col == c) {
                return "w";
            }
        }
        // queen
        for (i = 0; i < 1; i++) {
            if (Queens[i].row == r && Queens[i].col == c) {
                return "w";
            }
        }
        // king
        for (i = 0; i < 1; i++) {
            if (Kings[i].row == r && Kings[i].col == c) {
                return "w";
            }
        }

        // black pieces
        // pawns
        for (i = 8; i < 16; i++) {
            if (Pawns[i].row == r && Pawns[i].col == c) {
                return "b";
            }
        }
        // knights
        for (i = 2; i < 4; i++) {
            if (Knights[i].row == r && Knights[i].col == c) {
                return "b";
            }
        }
        // rooks
        for (i = 2; i < 4; i++) {
            if (Rooks[i].row == r && Rooks[i].col == c) {
                return "b";
            }
        }
        // bishops
        for (i = 2; i < 4; i++) {
            if (Bishops[i].row == r && Bishops[i].col == c) {
                return "b";
            }
        }
        // queens
        for (i = 1; i < 2; i++) {
            if (Queens[i].row == r && Queens[i].col == c) {
                return "b";
            }
        }
        // king
        for (i = 1; i < 2; i++) {
            if (Kings[i].row == r && Kings[i].col == c) {
                return "b";
            }
        }

        // if no piece is found
        return "n";
    }

    public static void takePiece(int r, int c) {
        /*
         * Finds piece being taken, takes it, then adds it to scoreBoard
         */

        // pawns
        for (i = 0; i < 16; i++) {
            if (Pawns[i].row == r && Pawns[i].col == c) {
                if (Pawns[i].isWhite) {
                    whiteTakenPieces[whiteTakenIndex] = Pawns[i].icon;
                    whiteTakenIndex++;
                } else {
                    blackTakenPieces[blackTakenIndex] = Pawns[i].icon;
                    blackTakenIndex++;
                }
                Pawns[i].row = -1;
                Pawns[i].col = -1;
            }
        }
        // knights
        for (i = 0; i < 4; i++) {
            if (Knights[i].row == r && Knights[i].col == c) {
                if (Knights[i].isWhite) {
                    whiteTakenPieces[whiteTakenIndex] = Knights[i].icon;
                    whiteTakenIndex++;
                } else {
                    blackTakenPieces[blackTakenIndex] = Knights[i].icon;
                    blackTakenIndex++;
                }
                Knights[i].row = -1;
                Knights[i].col = -1;
            }
        }
        // rooks
        for (i = 0; i < 4; i++) {
            if (Rooks[i].row == r && Rooks[i].col == c) {
                if (Rooks[i].isWhite) {
                    whiteTakenPieces[whiteTakenIndex] = Rooks[i].icon;
                    whiteTakenIndex++;
                } else {
                    blackTakenPieces[blackTakenIndex] = Rooks[i].icon;
                    blackTakenIndex++;
                }
                Rooks[i].row = -1;
                Rooks[i].col = -1;
            }
        }
        // bishops
        for (i = 0; i < 4; i++) {
            if (Bishops[i].row == r && Bishops[i].col == c) {
                if (Bishops[i].isWhite) {
                    whiteTakenPieces[whiteTakenIndex] = Bishops[i].icon;
                    whiteTakenIndex++;
                } else {
                    blackTakenPieces[blackTakenIndex] = Bishops[i].icon;
                    blackTakenIndex++;
                }
                Bishops[i].row = -1;
                Bishops[i].col = -1;
            }
        }
        // queens
        for (i = 0; i < 2; i++) {
            if (Queens[i].row == r && Queens[i].col == c) {
                if (Queens[i].isWhite) {
                    whiteTakenPieces[whiteTakenIndex] = Queens[i].icon;
                    whiteTakenIndex++;
                } else {
                    blackTakenPieces[blackTakenIndex] = Queens[i].icon;
                    blackTakenIndex++;
                }
                Queens[i].row = -1;
                Queens[i].col = -1;
            }
        }
        // kings
        for (i = 0; i < 2; i++) {
            if (Kings[i].row == r && Kings[i].col == c) {
                if (Kings[i].isWhite) {
                    whiteTakenPieces[whiteTakenIndex] = Kings[i].icon;
                    whiteTakenIndex++;
                } else {
                    blackTakenPieces[blackTakenIndex] = Kings[i].icon;
                    blackTakenIndex++;
                }
                Kings[i].row = -1;
                Kings[i].col = -1;
                if (i == 0) {
                    p2Win = true;
                } else if (i == 1) {
                    p1Win = true;
                }
            }
        }
    }

    public static void performPromotion() throws IOException, InterruptedException {
        /*
         * Promotes pawn.
         */
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println();
            // adds horizontal offset
            for (i = 0; i < hOffset; i++) {
                System.out.print(" ");
            }
            System.out.println("" + (char) (Pawns[promotionIndex].col + 65) + (8 - Pawns[promotionIndex].row)
                    + " available for promotion!");
            // adds horizontal offset
            for (i = 0; i < hOffset; i++) {
                System.out.print(" ");
            }
            System.out.println("Promotions available: Queen, Bishop, Rook, or Knight.\n");
            // adds horizontal offset
            for (i = 0; i < hOffset; i++) {
                System.out.print(" ");
            }
            System.out.print("Promote to...? (piece icon)[ex: 'n' for Knight]: ");
            String promoType = input.next().toLowerCase();

            if (Pawns[promotionIndex].promote(promoType)) {
                actionMessage = " " + (char) (Pawns[promotionIndex].col + 65) + (8 - Pawns[promotionIndex].row)
                        + " promoted.";
                render();
                promotion = false;
                break;
            }
            render();
            actionMessage = " Invaild promotion.";
        }
    }
}