import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TableTest {

    private Table table;

    @Before
    public void setup() {
        table = new Table();
    }

    @Test
    public void emptyTable()
    {
        String result = table.draw();
        assertEquals(
            " | | \n"
                + "-+-+-\n"
                + " | | \n"
                + "-+-+-\n"
                + " | | \n"
            , result);
    }

    @Test
    public void tableInsert()
    {
        table.insert(Player.PLAYER_ONE, 1, 1);
        String result = table.draw();
        assertEquals(
            " | | \n"
                + "-+-+-\n"
                + " |x| \n"
                + "-+-+-\n"
                + " | | \n"
            , result);
    }

    @Test
    public void multipleTableInsert()
    {
        table.insert(Player.PLAYER_ONE, 0, 0);
        table.insert(Player.PLAYER_TWO, 2, 1);
        String result = table.draw();
        assertEquals(
            " | | \n"
                + "-+-+-\n"
                + " | |o\n"
                + "-+-+-\n"
                + "x| | \n"
            , result);
    }

    @Test
    public void insertNonEmptyCell() {
        assertTrue(table.insert(Player.PLAYER_ONE, 0, 0));
        assertFalse(table.insert(Player.PLAYER_ONE, 0, 0));
    }

    @Test
    public void gameNotOver()
    {
        table.insert(Player.PLAYER_ONE, 0, 0);
        table.insert(Player.PLAYER_ONE, 0, 1);

        assertFalse(table.isGameOver());
    }

    @Test
    public void winInColumn()
    {
        table.insert(Player.PLAYER_ONE, 0, 0);
        table.insert(Player.PLAYER_ONE, 0, 1);
        table.insert(Player.PLAYER_ONE, 0, 2);

        assertTrue(table.isGameOver());
    }

    @Test
    public void winInRow()
    {
        table.insert(Player.PLAYER_ONE, 0, 2);
        table.insert(Player.PLAYER_ONE, 1, 2);
        table.insert(Player.PLAYER_ONE, 2, 2);

        assertTrue(table.isGameOver());
    }

    @Test
    public void winInDiagonal()
    {
        table.insert(Player.PLAYER_ONE, 0, 0);
        table.insert(Player.PLAYER_ONE, 1, 1);
        table.insert(Player.PLAYER_ONE, 2, 2);

        assertTrue(table.isGameOver());
    }


}
