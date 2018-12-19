package net.leanix.dev;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

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
        String result = "";
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (data[row][col] == BoardConstants.EMPTY) {
                    result += ' ';
                } else {
                    result += data[row][col].character;
                }
                if (col != 2) {
                    result += '|';
                }
            }
            result += '\n';
            if (row != 2) {
                result += "-+-+-";
            }

            result += '\n';
        }
        return result;
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
    public Optional<BoardConstants> get(int row, int col) {
        throw new RuntimeException();
    }

    public Optional<BoardConstants> determineWinner() {
        List<BoardConstants> playerStates = Arrays.asList(BoardConstants.PLAYER_ONE, BoardConstants.PLAYER_TWO);
        for (BoardConstants state : playerStates) {
            if (matchHorizontal(state) || matchVertical(state) || matchDiagonal(state)) {
                return Optional.of(state);
            }
        }
        return Optional.empty();
    }

    private boolean matchHorizontal(BoardConstants state) {
        for (BoardConstants[] row : data) {
            boolean result = Arrays.stream(row).allMatch(elementState -> elementState.equals(state));
            if (result) {
                return true;
            }
        }
        return false;
    }

    BoardConstants[] getCol(int col) {
        BoardConstants[] result = new BoardConstants[3];
        for (int row = 0; row < data.length; row++) {
            result[row] = data[row][col];
        }
        return result;
    }

    private boolean matchVertical(BoardConstants state) {
        for (int col = 0; col < data.length; col++) {
            BoardConstants[] colElement = getCol(col);
            boolean result = Arrays.stream(colElement).allMatch(elementState -> elementState.equals(state));
            if (result) {
                return true;
            }
        }
        return false;
    }

    private boolean matchDiagonal(BoardConstants state) {
        boolean result = IntStream.range(0, data.length).allMatch(i -> data[i][i].equals(state));
        if (result) {
            return true;
        }

        return IntStream.range(0, data.length).allMatch(i -> data[data.length - 1 - i][i].equals(state));
    }
}