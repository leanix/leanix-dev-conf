package net.leanix.dev;

import javafx.util.Pair;

public class CPUPlayerStrategy implements PlayerStrategy {

    @Override
    public Pair<Integer, Integer> getNextMove(ReadOnlyBoard board) {
        for (int row = 0; row < board.rowCount(); row++) {
            for (int col = 0; col < board.colCount(); col++) {
                if (board.get(row, col)
                    .filter(field -> field.equals(BoardConstants.EMPTY))
                    .isPresent()) {
                    return new Pair<>(row, col);
                }
            }
        }
        throw new RuntimeException();
    }
}
