public class Bishop{
    public int row, col;
    public boolean isWhite;
    public String icon;
    
    // normal constructor
    public Bishop(int r, int c, boolean isW, String i){
        row = r;
        col = c;
        isWhite = isW;
        icon = i;
    }
    
    public boolean move(int r, int c){
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
    }
}