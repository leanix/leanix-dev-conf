package net.leanix.dev;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Optional;
import java.util.StringJoiner;

public class Board {

    private static final int boardDimension = 3;

    private Cell[][] boardState = new Cell[][]{
        {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
        {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
        {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY}
    };

    public boolean isEmpty(int column, int row) {
        Preconditions.checkArgument(column < boardDimension && column >= 0);
        Preconditions.checkArgument(row < boardDimension && row >= 0);

        return boardState[column][row] == Cell.EMPTY;
    }

    public Optional<FinishedState> isFinished() {
        Optional<FinishedState> finishedState;
        // check rows
        finishedState = checkRows();
        if (finishedState.isPresent()) {
            return finishedState;
        }
        // check rows
        finishedState = checkColumns();
        if (finishedState.isPresent()) {
            return finishedState;
        }

        // check diagonals
        finishedState = checkDiagonal();
        if (finishedState.isPresent()) {
            return finishedState;
        }

        finishedState = checkReverseDiagonal();
        if (finishedState.isPresent()) {
            return finishedState;
        }

        return isBoardFull()
            ? Optional.of(new FinishedState(true, Cell.EMPTY))
            : Optional.empty();
    }

    protected Optional<FinishedState> checkReverseDiagonal() {
        Cell[] reverseDiagonalArray = new Cell[boardDimension];
        for (int j = boardDimension - 1; j >= 0; j--) {
            reverseDiagonalArray[boardDimension - j - 1] = boardState[boardDimension - j - 1][j];
        }
        return getFinishedState(reverseDiagonalArray);
    }

    protected Optional<FinishedState> checkDiagonal() {
        Cell[] diagonalArray = new Cell[boardDimension];
        for (int j = 0; j < boardDimension; j++) {
            diagonalArray[j] = boardState[j][j];
        }
        return getFinishedState(diagonalArray);

    }

    protected Optional<FinishedState> checkColumns() {
        Optional<FinishedState> finishedState;
        for (int i = 0; i < boardDimension; i++) {
            Cell[] columnArray = new Cell[boardDimension];
            for (int j = 0; j < boardDimension; j++) {
                columnArray[j] = boardState[j][i];
            }
            finishedState = getFinishedState(columnArray);
            if (finishedState.isPresent()) {
                return finishedState;
            }
        }
        return Optional.empty();
    }

    protected Optional<FinishedState> checkRows() {
        Optional<FinishedState> finishedState;
        for (int i = 0; i < boardDimension; i++) {
            finishedState = getFinishedState(boardState[i]);
            if (finishedState.isPresent()) {
                return finishedState;
            }
        }
        return Optional.empty();
    }

    private Optional<FinishedState> getFinishedState(Cell[] array) {
        ImmutableSet<Cell> reducedBoard = Arrays.stream(array)
            .collect(ImmutableSet.toImmutableSet());
        return reducedBoard.size() == 1 && !reducedBoard.contains(Cell.EMPTY)
            ? Optional.of(new FinishedState(false, reducedBoard.asList().get(0)))
            : Optional.empty();
    }

    protected boolean isBoardFull() {
        for (int i = 0; i < boardDimension; i++) {
            for (int j = 0; j < boardDimension; j++) {
                if (boardState[i][j] == Cell.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setBoardState(Cell[][] boardState) {
        this.boardState = boardState;
    }

    public void setCell(int rowNum, int colNum, Cell cell) {
        Preconditions.checkArgument(colNum < boardDimension && colNum>= 0);
        Preconditions.checkArgument(rowNum < boardDimension && rowNum >= 0);
        Preconditions.checkArgument(cell != Cell.EMPTY);

        boardState[rowNum][colNum] = cell;
    }

    public static class FinishedState {

        private final boolean isDraw;
        private final Cell winningSign;

        public FinishedState(boolean isDraw, Cell winningSign) {
            this.isDraw = isDraw;
            this.winningSign = winningSign;
        }

        public boolean isDraw() {
            return isDraw;
        }

        public Cell getWinningSign() {
            return winningSign;
        }
    }

    @Override
    public String toString() {
        StringJoiner outer = new StringJoiner("-+-+-");
        for (int i = boardDimension - 1; i >= 0; i--) {
            StringJoiner sb = new StringJoiner("|");
            for (int j = 0; j < boardDimension; j++) {
              sb.add(boardState[i][j].toString());
            }
            outer.add(sb.toString());
        }
        return outer.toString();
    }
}
