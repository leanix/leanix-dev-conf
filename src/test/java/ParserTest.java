import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

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
 }
