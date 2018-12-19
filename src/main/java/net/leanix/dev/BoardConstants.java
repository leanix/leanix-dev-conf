package net.leanix.dev;

public enum BoardConstants {
    PLAYER_ONE('x'), PLAYER_TWO('o'), EMPTY(' ');

    public final char character;
    BoardConstants(char character) {
        this.character = character;
    }
}
