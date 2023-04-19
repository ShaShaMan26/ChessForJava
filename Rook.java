public class Rook{
    public int row, col;
    public boolean isWhite;
    public String icon;
    
    // normal constructor
    public Rook(int r, int c, boolean isW, String i){
        row = r;
        col = c;
        isWhite = isW;
        icon = i;
    }
    
    public boolean move(int r, int c){
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
    }
}