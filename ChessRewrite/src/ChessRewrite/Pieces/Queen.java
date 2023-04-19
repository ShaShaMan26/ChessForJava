package ChessRewrite.Pieces;

import static java.lang.Math.abs;

public class Queen extends Piece {
    public Queen(int x, int y, boolean isW) {
        super(x, y, "q", isW);
    }

    @Override
    public Boolean canMakeMove(int x, int y) {
        return (abs(this.getXPos() - x) > 0 && abs(this.getYPos() - y) > 0
                && abs(this.getXPos() - x) == abs(this.getYPos() - y))
                || (abs(this.getXPos() - x) > 0 && abs(this.getYPos() - y) == 0)
                || (abs(this.getXPos() - x) == 0 && abs(this.getYPos() - y) > 0);
    }
}
