package ChessRewrite.Pieces;

import static java.lang.Math.abs;

public class Knight extends Piece {
    public Knight(int x, int y, boolean isW) {
        super(x, y, "n", isW);
    }

    @Override
    public Boolean canMakeMove(int x, int y) {
        return (this.getColorMod() * abs(this.getXPos() - x) == 2 && this.getColorMod() * abs(this.getYPos() - y) == 1)
                || (this.getColorMod() * abs(this.getXPos() - x) == 1 && this.getColorMod() * abs(this.getYPos() - y) == 2);
    }
}
