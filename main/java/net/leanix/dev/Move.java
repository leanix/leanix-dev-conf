package net.leanix.dev;

public class Move {
    private int x;  // row
    private int y;  //column

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        char letter = (char)('a' + y);
        return String.valueOf(letter) + (2-x);
    }
}
