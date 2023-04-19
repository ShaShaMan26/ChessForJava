package ChessRewrite.Pieces;

public abstract class Piece {
    private String icon;
    private boolean isWhite;
    private final int colorMod;
    private int xPos;
    private int yPos;

    public Piece(int x, int y, String i, Boolean isW) {
        xPos = x;
        yPos = y;
        icon = i;
        isWhite = isW;
        if (isW) {
            this.setIcon(this.getIcon().toUpperCase());
            colorMod = 1;
        } else {
            colorMod = -1;
        }
    }

    public boolean at(int x, int y) {
        return this.getXPos() == x && this.getYPos() == y;
    }
    public int getColorMod() {
        return colorMod;
    }
    public String getIcon() {
        return icon;
    }
    public int getXPos() {
        return xPos;
    }
    public int getYPos() {
        return yPos;
    }
    public boolean isWhite() {
        return isWhite;
    }

    /**
     * @param isW
     * true for White, false for Black
     */
    public void setColor(Boolean isW) {
        isWhite = isW;
    }
    public void setIcon(String i) {
        icon = i;
    }
    public void setXPos(int x) {
        xPos = x;
    }
    public void setYPos(int y) {
        yPos = y;
    }
    public void setXYPos(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public abstract Boolean canMakeMove(int x, int y);
    public void moveTo(int x, int y) {
        xPos = x;
        yPos = y;
    }
}
