package ChessRewrite.Pieces;

import static java.lang.Math.abs;

public class King extends Piece{
    public King(int x, int y, boolean isW) {
        super(x, y, "k", isW);
    }

    @Override
    public Boolean canMakeMove(int x, int y) {
        return abs(this.getXPos() - x) == 1 || abs(this.getYPos() - y) == 1;
    }
}
