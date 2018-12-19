package net.leanix.dev;

import java.util.Arrays;
import java.util.Optional;

public class Board implements ReadOnlyBoard {
    private BoardConstants[][] data;

    Board() {
        init();
    }

    private void init() {
        data = new BoardConstants[3][3];
        for (BoardConstants[] row : data) {
            Arrays.fill(row, BoardConstants.EMPTY);
        }
    }

    @Override
    public String toString() {
        throw new RuntimeException();
    }

    @Override
    public boolean isFull() {
        for (BoardConstants[] row : data) {
            for (BoardConstants element : row) {
                if (element.equals(BoardConstants.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean set(BoardConstants state, int row, int col) {
        if (data[row][col].equals(BoardConstants.EMPTY)) {
            data[row][col] = state;
            return true;
        }
        return false;
    }

    @Override
    public Optional<Character> get(int row, int col) {
        throw new RuntimeException();
    }

    public Optional<Character> determineWinner() {
        throw new RuntimeException();
    }

}