public class King{
    public int row, col;
    public boolean isWhite;
    public String icon;
    
    // normal constructor
    public King(int r, int c, boolean isW, String i){
        row = r;
        col = c;
        isWhite = isW;
        icon = i;
    }
    
    public boolean move(int r, int c){
        if (Math.abs(row - r) == 1 || Math.abs(col - c) == 1){
            Chess.takePiece(r, c);
            row = r;
            col = c;
            return true;
        }
        return false;
    }
}