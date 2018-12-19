package net.leanix.dev;

import javax.naming.OperationNotSupportedException;

public class Move {
    private int x;  // row
    private int y;  //column

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Move(char column, int row) throws OperationNotSupportedException {
        this.y = row;
        this.x = getXMapping(column);
    }

    private int getXMapping(char c) throws OperationNotSupportedException {
        switch (c) {
            case 'A':
            case 'a':
                return 0;
            case 'B':
            case 'b':
                return 1;
            case 'C':
            case 'c':
                return 2;
            default:
                throw new OperationNotSupportedException("Invalid column input.");
        }
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
