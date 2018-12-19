package net.leanix.dev.tictactoe;

public class Coordinate {

    private final int x;
    private final int y;


    /**
     *
     * @param x has to be between 0 and 8
     * @param y has to be between 0 and 8
     */
    public Coordinate(int x, int y) {
        if (x < 0 || x > 8) {
            throw new IllegalArgumentException("Illegal x value " + x);
        }
        if (y < 0 || y > 8) {
            throw new IllegalArgumentException("Illegal y value " + y);
        }

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
