package ChessRewrite.Pieces;

public class Pawn extends Piece {
    private boolean firstMove = true;
    private boolean diagonalOfPiece = false;
    private boolean inFrontOfPiece = false;

    public Pawn(int x, int y, boolean isW) {
        super(x, y, "p", isW);
    }

    public boolean getIsDiagonalOfPiece() {
        return diagonalOfPiece;
    }

    public void setIsDiagonalOfPiece(boolean diagonalOfPiece) {
        this.diagonalOfPiece = diagonalOfPiece;
    }
    public void setIsInFrontOfPiece(boolean inFrontOfPiece) {
        this.inFrontOfPiece = inFrontOfPiece;
    }

    @Override
    public Boolean canMakeMove(int x, int y) {
        if (inFrontOfPiece) {
            if (diagonalOfPiece) {
                return (this.getXPos() + this.getColorMod() == x
                        || this.getXPos() - this.getColorMod() == x)
                        && this.getYPos() - this.getColorMod() == y;
            }
            return false;
        }

        if (firstMove) {
            if (diagonalOfPiece) {
                return (this.getXPos() == x
                        && (this.getYPos() - y == 2 * this.getColorMod()
                        || this.getYPos() - y == this.getColorMod())
                        || ((this.getXPos() + this.getColorMod() == x
                        || this.getXPos() - this.getColorMod() == x))
                        && this.getYPos() - this.getColorMod() == y );
            }
            return (this.getXPos() == x
                    && (this.getYPos() - y == 2 * this.getColorMod()
                    || this.getYPos() - y == this.getColorMod()));
        }

        if (diagonalOfPiece) {
            return ((this.getXPos() + this.getColorMod() == x
                    || this.getXPos() - this.getColorMod() == x)
                    && this.getYPos() - this.getColorMod() == y)
                    || (this.getXPos() == x
                    && this.getYPos() - y == this.getColorMod());
        }

        return this.getXPos() == x
                && this.getYPos() - y == this.getColorMod();
    }
    @Override
    public void moveTo(int x, int y) {
        super.moveTo(x, y);
        firstMove = false;
    }
}
