package net.leanix.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.naming.OperationNotSupportedException;
import javafx.util.Pair;

public class Board {
    CellState[][] cells = new CellState[3][3];

    public Board() {
        for (CellState[] row: cells) {
            Arrays.fill(row, CellState.EMPTY);
        }
    }

    public boolean attemptMove(Player player, int row, int column) {

        boolean isInbounds = row >= 0 && row < 3 && column >= 0 && column < 3;
        boolean isStateEmpty = cells[row][column] == CellState.EMPTY;
        if (isInbounds && isStateEmpty) {
            cells[row][column] = player.getCellState();
            return true;
        } else {
            return false;
        }
    }

    public void render() {
        String boardString = Arrays.stream(cells)
            .map(this::toRowString)
            .collect(Collectors.joining("-+-+-\n"));
        System.out.println(boardString);
    }

    private String toRowString(CellState[] row) {
        return Arrays.stream(row)
            .map(CellState::toString)
            .collect(Collectors.joining("|")) + "\n";
    }

    public GameState getUpdatedState() throws OperationNotSupportedException {
        // 1. check for winner
        for (CellState[] row: cells) {
            // every row
            if (Arrays.asList(row).stream().allMatch(cell -> cell == row[0] && cell != CellState.EMPTY)) {
                return mapCellState(row[0]);
            }
        }

        // every column
        for (int i = 0; i < 3; i++) {
            if (cells[0][i] != CellState.EMPTY && cells[0][i] == cells[1][i] && cells[0][i] == cells[2][i]) {
                return mapCellState(cells[0][i]);
            }
        }

        // diagonal
        if (cells[0][0] != CellState.EMPTY && cells[0][0] == cells[1][1] && cells[0][0] == cells[2][2]) {
            return mapCellState(cells[0][0]);
        }
        if (cells[0][2] != CellState.EMPTY && cells[0][2] == cells[1][1] && cells[0][2] == cells[2][0]) {
            return mapCellState(cells[0][2]);
        }

        // 2. check for board is full
        if (Arrays.asList(cells)
            .stream()
            .allMatch(row ->
                Arrays.asList(row)
                    .stream()
                    .allMatch(cell -> cell != CellState.EMPTY))) {
            return GameState.DRAW;
        }

        // else
        return GameState.ONGOING;
    }

    private GameState mapCellState(CellState state) throws OperationNotSupportedException {
        switch (state) {
            case X:
                return GameState.WIN1;
            case O:
                return GameState.WIN2;
            default:
                throw new OperationNotSupportedException("Only player 1 or 2 can win.");
        }
    }

    public List<Pair<Integer,Integer>> getEmptyCells() {
        List<Pair<Integer,Integer>> emptyCells = new ArrayList<>();
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(cells[i][j] == CellState.EMPTY) {
                    emptyCells.add(new Pair<>(i,j));
                }
            }
        }
        return emptyCells;
    }
}
