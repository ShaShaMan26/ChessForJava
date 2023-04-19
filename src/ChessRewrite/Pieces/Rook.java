package ChessRewrite.Pieces;

import static java.lang.Math.abs;

public class Rook extends Piece{
    public Rook(int x, int y, boolean isW) {
        super(x, y, "r", isW);
    }

    @Override
    public Boolean canMakeMove(int x, int y) {
        return (abs(this.getXPos() - x) > 0 && abs(this.getYPos() - y) == 0)
                || (abs(this.getXPos() - x) == 0 && abs(this.getYPos() - y) > 0);
    }
}
