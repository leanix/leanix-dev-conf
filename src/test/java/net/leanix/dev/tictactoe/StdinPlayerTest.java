package net.leanix.dev.tictactoe;

import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.Optional;

public class StdinPlayerTest {

    private StdinPlayer player = new StdinPlayer(0, new ConsoleOutput());

    @Test
    public void testA1() {
        Optional<Coordinate> coordinate = player.parseCoordinate("a1");
        Assert.that(coordinate.isPresent(), "coordinates missing");
        org.junit.Assert.assertEquals(coordinate.get().getX(), 0);
        org.junit.Assert.assertEquals(coordinate.get().getY(), 1);
    }

    @Test
    public void testC2() {
        Optional<Coordinate> coordinate = player.parseCoordinate("C2");
        Assert.that(coordinate.isPresent(), "coordinates missing");
        org.junit.Assert.assertEquals(coordinate.get().getX(), 2);
        org.junit.Assert.assertEquals(coordinate.get().getY(), 2);
    }

    @Test
    public void testD2() {
        Optional<Coordinate> coordinate = player.parseCoordinate("d2");
        Assert.that(!coordinate.isPresent(), "should be invalid");
    }

    @Test
    public void testA4() {
        Optional<Coordinate> coordinate = player.parseCoordinate("a4");
        Assert.that(!coordinate.isPresent(), "should be invalid");
    }

    @Test
    public void testA1A() {
        Optional<Coordinate> coordinate = player.parseCoordinate("a1a");
        Assert.that(!coordinate.isPresent(), "should be invalid");
    }
}
