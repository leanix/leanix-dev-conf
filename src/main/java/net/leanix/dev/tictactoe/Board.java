package net.leanix.dev.tictactoe;

public class Board {

    int[9]state;

    public Board() {

    }

    /**
     *
     * @param coordinate values
     * @param state 0 is empty, 1/2 is player number
     */
    public void setCellState(Coordinate coordinate, int state) {
        if (state < 0 || state > 2) {
            
        }
        int x = coordinate.getX();
        int y = coordinate.getY();

        state[x + y * 3] = state;
    }

    public int getCellState(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        return state[x + y * 3];
    }
}
