public class Knight{
    public int row, col;
    public boolean isWhite;
    public String icon;
    
    // normal constructor
    public Knight(int r, int c, boolean isW, String i){
        row = r;
        col = c;
        isWhite = isW;
        icon = i;
    }
    
    public boolean move(int r, int c){
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