package net.leanix.dev;

import javafx.util.Pair;

public class CPUPlayer implements Player {

    @Override
    public Pair<Integer, Integer> getNextMove(ReadOnlyBoard board) {
        throw new RuntimeException();
    }
}
