package net.leanix.dev;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardTest {

    @Test
    public void getOngoingStateTest() {
        Board board = new Board();
        try {
            GameState state = board.getUpdatedState();
            assertEquals(state, GameState.ONGOING);
        } catch (Exception ex) {
            assertTrue(false);
        }
    }
}
