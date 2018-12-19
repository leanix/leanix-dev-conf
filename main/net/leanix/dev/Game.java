package net.leanix.dev;

public class Game {

    public void run() {
        do{
            next();
        } while (!isFinished());
    }

    public boolean isFinished() {

        return false;
    }

    private void next() {
        // handle next step depending of the state of the game
    }

    private void switchPlayer() {

    }

    private void markCell() {

    }

}
