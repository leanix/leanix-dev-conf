package net.leanix.dev;

import static org.junit.Assert.assertEquals;

import javafx.util.Pair;
import java.util.Optional;
import org.junit.Test;

public class HumanPlayerStrategyTest {
    @Test
    public void decodesInput() {
        Optional<Pair<Integer, Integer>> result = HumanPlayerStrategy.decode("a1");
        assertEquals(Optional.of(new Pair<>(1, 0)), result);
    }

    @Test
    public void doesNotDecodeInput() {
        Optional<Pair<Integer, Integer>> result = HumanPlayerStrategy.decode("z1");
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void doesNotDecodeEmptyInput() {
        Optional<Pair<Integer, Integer>> result = HumanPlayerStrategy.decode("");
        assertEquals(Optional.empty(), result);
    }
}
