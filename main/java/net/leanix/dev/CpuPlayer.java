package net.leanix.dev;

import java.util.List;
import java.util.Random;

public class CpuPlayer extends BasePlayer implements Player {

    public CpuPlayer(String name, CellState symbol) {
        super(name, symbol);
    }

    @Override
    public void move(Board board) {
        List<Move> emptyCells = board.getPossibleMoves();
        Random rand = new Random();
        int moveIndex = rand.nextInt(emptyCells.size());
        Move nextMove = emptyCells.get(moveIndex);
        board.attemptMove(this, nextMove.getX(), nextMove.getY());
        System.out.println( getName() + ">" + nextMove.toString());
    }
}
