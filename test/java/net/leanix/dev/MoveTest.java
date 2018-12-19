package net.leanix.dev;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MoveTest {
    @Test
    public void getMoveStringTest() {
        Move move = new Move(0,0);
        String moveString = move.toString();
        assertTrue(moveString.equals("a2"));
    }
}