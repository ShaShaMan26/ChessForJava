import java.util.*;
public class Pawn{
    public int row, col;
    public boolean firstMove, isWhite, hasPromoted;
    public String icon;
    
    // normal constructor
    public Pawn(int r, int c, boolean t, String i){
        col = c;
        row = r;
        isWhite = t;
        icon = i;
        firstMove = true;
        hasPromoted = false;
    }
    
    public boolean move(int r, int c){
        if (hasPromoted){
            // promoted to queen
            if (icon.toLowerCase().equals("q")){
                if (Math.abs(row - r) > 0 || Math.abs(col - c) > 0){
                    // up right
                    if ((row - r) == Math.abs(col - c)){
                        for (int i = 1; i < Math.abs(row - r); i++){
                            if (Chess.pieceAt((row - i), (col + i))){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    // up left
                    } else if ((row - r) == (col - c)){
                        for (int i = 1; i < Math.abs(row - r); i++){
                            if (Chess.pieceAt((row - i), (col - i))){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    // down left
                    } else if ((row + r) == (col - c)){
                        for (int i = 1; i < Math.abs(row - r); i++){
                            if (Chess.pieceAt((row + i), (col - i))){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    // down right
                    } else if ((row + r) == (col + c)){
                        for (int i = 1; i < Math.abs(row - r); i++){
                            if (Chess.pieceAt((row + i), (col + i))){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    } else if (row < r){
                        for (int i = 1; i < Math.abs(row - r); i++){
                            if (Chess.pieceAt((row + i), col)){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    } else if (row > r){
                        for (int i = 1; i < Math.abs(row - r); i++){
                            if (Chess.pieceAt((row - i), col)){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    } else if (col < c){
                        for (int i = 1; i < Math.abs(col - c); i++){
                            if (Chess.pieceAt(row, (col + i))){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    } else if (col > c){
                        for (int i = 1; i < Math.abs(col - c); i++){
                            if (Chess.pieceAt(row, (col - i))){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            // promoted to bishop
            } else if (icon.toLowerCase().equals("b")){
                if (Math.abs(row - r) > 0 && Math.abs(col - c) > 0){
                    // up right
                    if ((row - r) == Math.abs(col - c)){
                        for (int i = 1; i < Math.abs(row - r); i++){
                            if (Chess.pieceAt((row - i), (col + i))){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    // up left
                    } else if ((row - r) == (col - c)){
                        for (int i = 1; i < Math.abs(row - r); i++){
                            if (Chess.pieceAt((row - i), (col - i))){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    // down left
                    } else if ((row + r) == (col - c)){
                        for (int i = 1; i < Math.abs(row - r); i++){
                            if (Chess.pieceAt((row + i), (col - i))){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    // down right
                    } else if ((row + r) == (col + c)){
                        for (int i = 1; i < Math.abs(row - r); i++){
                            if (Chess.pieceAt((row + i), (col + i))){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            // promoted to rook
            } else if (icon.toLowerCase().equals("r")){
                if (Math.abs(row - r) > 0 && c == col){
                    if (row < r){
                        for (int i = 1; i < Math.abs(row - r); i++){
                            if (Chess.pieceAt((row + i), col)){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    } else {
                        for (int i = 1; i < Math.abs(row - r); i++){
                            if (Chess.pieceAt((row - i), col)){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    }
                } else if (r == row && Math.abs(col - c) > 0){
                    if (col < c){
                        for (int i = 1; i < Math.abs(col - c); i++){
                            if (Chess.pieceAt(row, (col + i))){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    } else {
                        for (int i = 1; i < Math.abs(col - c); i++){
                            if (Chess.pieceAt(row, (col - i))){
                                return false;
                            }
                        }
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    }
                } else {
                    return false;
                }
            // promoted to knight
            } else {
                if ((Math.abs(row - r) == 1 && Math.abs(col - c) == 2) || (Math.abs(row - r) == 2 && Math.abs(col - c) == 1)){
                    if (Chess.pieceAt(r, c)){
                        Chess.takePiece(r, c);
                        row = r;
                        col = c;
                        return true;
                    } else if (!Chess.pieceAt(r, c)){
                        row = r;
                        col = c;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        
        if (isWhite){
            // piece diagnal and move diagnal and not same color
            if ((((col - c) == 1 && (row - r) == 1) 
            && ((Chess.pieceAt((row - 1), (col - 1)))))
            || (((col - c) == -1 && (row - r) == 1) 
            && (Chess.pieceAt((row - 1), (col + 1))))){
                Chess.takePiece(r, c);
                col = c;
                row = r;
                return true;
            // move up one but piece in front
            } else if (Chess.pieceAt((row - 1), col)){
                return false;
            // move up one
            } else if (Math.abs(col - c) == 0 
            && (row - r == 1)){
                col = c;
                row = r;
                return true;
            // first move and move up one or two and no piece up two
            } else if (firstMove 
            && Math.abs(col - c) == 0 
            && (row - r == 1 || row - r == 2)
            && Chess.pieceAt(row - 2, col) == false){
                col = c;
                row = r;
                firstMove = false;
                return true;
            } else {
                return false;
            }
        } else {
            // move up one but piece in front
            if ((((col - c) == -1 && (row - r) == -1) 
            && ((Chess.pieceAt((row + 1), (col + 1)))))
            || (((col - c) == 1 && (row - r) == -1) 
            && (Chess.pieceAt((row + 1), (col - 1))))){
                Chess.takePiece(r, c);
                col = c;
                row = r;
                return true;
            // first move and move up one or two and no piece up two
            } else if (Chess.pieceAt((row + 1), col)){
                return false;
            // move up one
            } else if (Math.abs(col - c) == 0 
            && (row - r == -1)){
                col = c;
                row = r;
                return true;
            // piece diagnal and move diagnal and not same color
            } else if (firstMove 
            && Math.abs(col - c) == 0 
            && (row - r == -1 || row - r == -2)
            && Chess.pieceAt(row + 2, col) == false){
                col = c;
                row = r;
                firstMove = false;
                return true;
            } else {
                return false;
            }
        }
    }
    
    public boolean promote(String toPiece){
        toPiece = toPiece.toLowerCase();
        
        if (toPiece.equals("q")
        || toPiece.equals("b")
        || toPiece.equals("r")
        || toPiece.equals("n")){
            if (isWhite){
                toPiece = toPiece.toUpperCase();
            }
            icon = toPiece;
            hasPromoted = true;
            return true;
        } else {
            return false;
        }
    }
}