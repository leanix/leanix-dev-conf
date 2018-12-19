package net.leanix.dev;

import javafx.util.Pair;

public interface Player {
    Pair<Integer, Integer> getNextMove(ReadOnlyBoard board);
}
