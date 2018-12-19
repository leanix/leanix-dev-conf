package net.leanix.dev;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Map.Entry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InputHandlerTest {

    private InputHandler inputHandler;
    private Board mockedBoard = mock(Board.class);

    @Before
    public void setup() {
        inputHandler = new InputHandler(mockedBoard);
    }

    @Test
    public void inputIsInvalid() {
        when(mockedBoard.isEmpty(anyInt(), anyInt())).thenReturn(true);
        Assert.assertTrue(inputHandler.inputIsInvalid(""));
        Assert.assertFalse(inputHandler.inputIsInvalid("a1"));
        Assert.assertFalse(inputHandler.inputIsInvalid("b2"));
        Assert.assertFalse(inputHandler.inputIsInvalid("c0"));
        Assert.assertTrue(inputHandler.inputIsInvalid("C3"));
        Assert.assertTrue(inputHandler.inputIsInvalid("a5"));
        Assert.assertTrue(inputHandler.inputIsInvalid("aC3"));
        Assert.assertTrue(inputHandler.inputIsInvalid("C34"));
        when(mockedBoard.isEmpty(anyInt(), anyInt())).thenReturn(false);
        Assert.assertTrue(inputHandler.inputIsInvalid("a1"));
        Assert.assertTrue(inputHandler.inputIsInvalid("b2"));
        Assert.assertTrue(inputHandler.inputIsInvalid("c0"));
    }

    @Test
    public void splitInputString() {
        Entry<Integer, Integer> result = InputHandler.splitInputString("a2");
        int key = result.getKey();
        int value = result.getValue();
        Assert.assertEquals(0, key);
        Assert.assertEquals(2, value);
    }
}