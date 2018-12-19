package net.leanix.dev.tictactoe;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class StdinPlayerTest {

    private StdinPlayer player = new StdinPlayer(1, new ConsoleOutput());

    @Test
    public void testA1() {
        Optional<Coordinate> coordinate = player.parseCoordinate("a1");
        Assert.assertTrue(coordinate.isPresent());
        org.junit.Assert.assertEquals(coordinate.get().getX(), 0);
        org.junit.Assert.assertEquals(coordinate.get().getY(), 1);
    }

    @Test
    public void testC2() {
        Optional<Coordinate> coordinate = player.parseCoordinate("C2");
        Assert.assertTrue(coordinate.isPresent());
        org.junit.Assert.assertEquals(coordinate.get().getX(), 2);
        org.junit.Assert.assertEquals(coordinate.get().getY(), 2);
    }

    @Test
    public void testD2() {
        Optional<Coordinate> coordinate = player.parseCoordinate("d2");
        Assert.assertFalse(coordinate.isPresent());
    }

    @Test
    public void testA4() {
        Optional<Coordinate> coordinate = player.parseCoordinate("a4");
        Assert.assertFalse(coordinate.isPresent());
    }

    @Test
    public void testA1A() {
        Optional<Coordinate> coordinate = player.parseCoordinate("a1a");
        Assert.assertFalse(coordinate.isPresent());
    }
}
