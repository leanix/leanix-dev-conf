package net.leanix.dev;

import java.util.Optional;

public interface ReadOnlyBoard {
    String toString();
    boolean isFull();
    Optional<BoardConstants> get(int row, int col);
    int rowCount();
    int colCount();
}