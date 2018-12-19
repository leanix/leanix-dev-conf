import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game game;

    @Before
    public void setup() {
        Table table = new Table();
        game = new Game(table, Player.PLAYER_TWO);
    }

    @Test
    public void initialState() {
        assertEquals(new GameState(Player.PLAYER_TWO, Message.ENTER_COMMAND), game.getState());
    }

    @Test
    public void playSingleMove() {
        game.runCommand("a1");
        assertEquals(new GameState(Player.PLAYER_ONE, Message.ENTER_COMMAND), game.getState());
    }

    @Test
    public void playInvalidMove() {
        game.runCommand("a1");
        assertEquals(new GameState(Player.PLAYER_ONE, Message.ENTER_COMMAND), game.getState());
        game.runCommand("a1");
        assertEquals(new GameState(Player.PLAYER_ONE, Message.CELL_NOT_EMPTY), game.getState());
    }
}
