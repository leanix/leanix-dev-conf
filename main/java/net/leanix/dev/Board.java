package net.leanix.dev;

import java.util.Arrays;

public class Board {
    CellState[][] cells = new CellState[3][3];

    public Board() {
        for (CellState[] row: cells) {
            Arrays.fill(row, CellState.EMPTY);
        }
    }

    public boolean attemptMove(Player player, int x, int y) {
        // validate coordinates

        cells[x][y] = player.getCellState();
        return true;
    }

    public void render() {
    }

    public GameState getUpdatedState() {
        return GameState.DRAW;
    }
}
