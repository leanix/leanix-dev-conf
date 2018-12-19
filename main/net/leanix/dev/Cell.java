package net.leanix.dev;

public enum Cell {
    EMPTY,
    CIRCLE,
    CROSS;

    @Override
    public String toString() {
        if (this == EMPTY) {
            return " ";
        } else if (this == CIRCLE) {
            return "0";
        } else {
            return "X";
        }
    }
}

