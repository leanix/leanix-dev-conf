package net.leanix.dev;

public enum CellState {
    EMPTY,
    X,
    O;

    @Override
    public String toString() {
        switch(this){
            case O:
                return "O";
            case X:
                return "X";
            case EMPTY:
            default:
                return " ";
        }
    }
}
