package net.leanix.dev;

import java.util.Arrays;
import java.util.Optional;

public class Board implements ReadOnlyBoard {
    private BoardConstants[][] data;

    public Board() {
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
        throw new RuntimeException();
    }

    public boolean set(char player, int row, int col) {
        throw new RuntimeException();
    }

    @Override
    public Optional<Character> get(int row, int col) {
        throw new RuntimeException();
    }

    public Optional<Character> determineWinner() {
        throw new RuntimeException();
    }

}