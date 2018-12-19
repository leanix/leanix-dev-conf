package net.leanix.dev;

import javafx.util.Pair;

public interface PlayerStrategy {
    Pair<Integer, Integer> getNextMove(ReadOnlyBoard board);
}
