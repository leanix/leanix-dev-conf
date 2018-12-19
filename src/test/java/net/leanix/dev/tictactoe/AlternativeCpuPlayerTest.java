package net.leanix.dev.tictactoe;

import org.junit.Test;

public class AlternativeCpuPlayerTest {

    private AlternativeCpuPlayer player = new AlternativeCpuPlayer(2);

    @Test
    public void testWinningMove() {
        Board board = new Board();
        board.setState(new int[]{
            2, 0, 2,
            0, 1, 1,
            1, 0, 0
        });
        Coordinate move = player.submitMove(board);
        org.junit.Assert.assertEquals(move.getX(), 0);
        org.junit.Assert.assertEquals(move.getY(), 1);
    }

    @Test
    public void testBlockingMove() {
        Board board = new Board();
        board.setState(new int[]{
            2, 0, 0,
            1, 0, 1,
            2, 0, 0
        });
        Coordinate move = player.submitMove(board);
        org.junit.Assert.assertEquals(move.getX(), 1);
        org.junit.Assert.assertEquals(move.getY(), 1);
    }

}

