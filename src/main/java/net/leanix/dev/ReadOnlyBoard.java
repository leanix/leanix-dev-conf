package net.leanix.dev;

import java.util.Optional;

public interface ReadOnlyBoard {
    String toString();
    boolean isFull();
    Optional<Character> get(int row, int col);
}