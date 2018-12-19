package net.leanix.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

    public GameState getUpdatedState() {
        return GameState.DRAW;
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
