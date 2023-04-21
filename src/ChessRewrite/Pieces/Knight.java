package ChessRewrite.Pieces;

import static java.lang.Math.abs;

public class Knight extends Piece {
    public Knight(int x, int y, boolean isW) {
        super(x, y, "n", isW);
    }

    @Override
    public Boolean canMakeMove(int x, int y) {
        return (abs(this.getXPos() - x) == 2 && abs(this.getYPos() - y) == 1)
                || (abs(this.getXPos() - x) == 1 && abs(this.getYPos() - y) == 2);
    }
}
