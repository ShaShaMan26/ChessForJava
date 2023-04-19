package ChessRewrite.Pieces;

import static java.lang.Math.abs;

public class Bishop extends Piece {
    public Bishop(int x, int y, boolean isW) {
        super(x, y, "b", isW);
    }

    @Override
    public Boolean canMakeMove(int x, int y) {
        return (abs(this.getXPos() - x) > 0 && abs(this.getYPos() - y) > 0
                && abs(this.getXPos() - x) == abs(this.getYPos() - y));
    }
}
