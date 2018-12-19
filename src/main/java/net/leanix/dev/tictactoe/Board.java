package net.leanix.dev.tictactoe;

public class Board {

    private int[] state = new int[9];

    public Board() {

    }

    public int[] getState() {
        return state;
    }

    public void setState(int[] state) {
        this.state = state;
    }

    /**
     *
     * @param coordinate values
     * @param state 0 is empty, 1/2 is player number
     */
    public void setCellState(Coordinate coordinate, int state) {
        if (state < 0 || state > 2) {
            throw new IllegalArgumentException("Illegal state argument: " + state);
        }
        int x = coordinate.getX();
        int y = coordinate.getY();

        this.state[x + y * 3] = state;
    }

    public int getCellState(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        return state[x + y * 3];
    }
}
