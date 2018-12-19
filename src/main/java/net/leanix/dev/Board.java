package net.leanix.dev;

import java.util.Optional;

public class Board implements ReadOnlyBoard {
    private char[][] data = new char[3][3];

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