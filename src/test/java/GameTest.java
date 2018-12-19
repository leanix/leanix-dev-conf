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
        assertEquals(game.getState(), new GameState(Player.PLAYER_TWO, Message.ENTER_COMMAND));
    }
}
