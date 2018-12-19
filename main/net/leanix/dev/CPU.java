package net.leanix.dev;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map;
import java.util.Random;

public class CPU {

    public static Map.Entry<Integer, Integer> chooseCellCoordinates () {
        return new SimpleImmutableEntry<>(defineRandomInt(), defineRandomInt());
    }

    private static int defineRandomInt() {
        Random r = new Random();
        int low = 0;
        int high = 3;
        return r.nextInt(high-low) + low;

    }
}
