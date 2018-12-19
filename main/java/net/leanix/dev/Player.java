package net.leanix.dev;

public interface Player {

    void move(Board board);

    CellState getCellState();

    String getName();
}
