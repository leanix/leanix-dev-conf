package net.leanix.dev.tictactoe;

import org.junit.Test;

public class AlternativeCpuPlayerTest {

    private AlternativeCpuPlayer player = new AlternativeCpuPlayer(2, new ConsoleOutput());

    @Test
    public void testWinningMove() {
        Board board = new Board();
        board.setState(new int[]{
            2, 0, 2,
            0, 1, 1,
            1, 0, 0
        });
        Coordinate move = player.submitMove(board);
        org.junit.Assert.assertEquals(move.getX(), 1);
        org.junit.Assert.assertEquals(move.getY(), 0);
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

    @Test
    public void testBlockingMove2() {
        Board board = new Board();
        board.setState(new int[]{
            1, 2, 1,
            0, 1, 2,
            0, 1, 2
        });
        Coordinate move = player.submitMove(board);
        org.junit.Assert.assertEquals(move.getX(), 0);
        org.junit.Assert.assertEquals(move.getY(), 2);
    }

    @Test
    public void testMoveThatWillLeadToSubsequentWin() {
        Board board = new Board();
        board.setState(new int[]{  // 9 marks a field that neither player is allowed to use to simplify this test case
            2, 0, 0,
            0, 9, 0,
            9, 0, 2
        });
        Coordinate move = player.submitMove(board);
        System.out.println(move.getX() + ", " + move.getY());
        org.junit.Assert.assertEquals(move.getX(), 2);
        org.junit.Assert.assertEquals(move.getY(), 0);
    }

}

