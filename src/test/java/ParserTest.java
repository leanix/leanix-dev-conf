import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ParserTest {

    @Test
    public void validLetterNumber()
    {
        assertEquals(new Coordinate(0, 0), Parser.parse("a1"));
        assertEquals(new Coordinate(0, 1), Parser.parse("a2"));
        assertEquals(new Coordinate(0, 2), Parser.parse("a3"));
        assertEquals(new Coordinate(1, 0), Parser.parse("b1"));
        assertEquals(new Coordinate(1, 1), Parser.parse("b2"));
        assertEquals(new Coordinate(1, 2), Parser.parse("b3"));
        assertEquals(new Coordinate(2, 0), Parser.parse("c1"));
        assertEquals(new Coordinate(2, 1), Parser.parse("c2"));
        assertEquals(new Coordinate(2, 2), Parser.parse("c3"));
    }


    @Test
    public void validNumberLetter()
    {
        assertEquals(new Coordinate(0, 0), Parser.parse("1a"));
        assertEquals(new Coordinate(0, 1), Parser.parse("2a"));
        assertEquals(new Coordinate(0, 2), Parser.parse("3a"));
        assertEquals(new Coordinate(1, 0), Parser.parse("1b"));
        assertEquals(new Coordinate(1, 1), Parser.parse("2b"));
        assertEquals(new Coordinate(1, 2), Parser.parse("3b"));
        assertEquals(new Coordinate(2, 0), Parser.parse("1c"));
        assertEquals(new Coordinate(2, 1), Parser.parse("2c"));
        assertEquals(new Coordinate(2, 2), Parser.parse("3c"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooManyNumbers()
    {
        Parser.parse("11a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooManyLetters()
    {
        Parser.parse("2aa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongNumber()
    {
        Parser.parse("0a");
    }


    @Test(expected = IllegalArgumentException.class)
    public void wrongLetter()
    {
        Parser.parse("1d");
    }


    @Test(expected = IllegalArgumentException.class)
    public void tooShort()
    {
        Parser.parse("1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyString()
    {
        Parser.parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullString()
    {
        Parser.parse(null);
    }
}
