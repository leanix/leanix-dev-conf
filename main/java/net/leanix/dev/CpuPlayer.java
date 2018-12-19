package net.leanix.dev;

import java.util.List;
import java.util.Random;
import javafx.util.Pair;

public class CpuPlayer extends BasePlayer implements Player {

    public CpuPlayer(String name, CellState symbol) {
        super(name, symbol);
    }

    @Override
    public void move(Board board) {
        List<Pair<Integer,Integer>> emptyCells = board.getEmptyCells();
        Random rand = new Random();
        int moveIndex = rand.nextInt(emptyCells.size());
        Pair<Integer, Integer> nextMove = emptyCells.get(moveIndex);
        board.attemptMove(this, nextMove.getKey(), nextMove.getValue());
    }
}
