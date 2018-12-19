package net.leanix.dev;

import java.util.Map.Entry;
import org.junit.Assert;
import org.junit.Test;

public class InputHandlerTest {

    @Test
    public void inputIsInvalid() {
        Assert.assertTrue(InputHandler.inputIsInvalid("a1"));
        Assert.assertTrue(InputHandler.inputIsInvalid("b2"));
        Assert.assertTrue(InputHandler.inputIsInvalid("c0"));
        Assert.assertFalse(InputHandler.inputIsInvalid("C3"));
        Assert.assertFalse(InputHandler.inputIsInvalid("a5"));
        Assert.assertFalse(InputHandler.inputIsInvalid("aC3"));
        Assert.assertFalse(InputHandler.inputIsInvalid("C34"));
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