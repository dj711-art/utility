package org.own.iterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainPeakTest {

    private final int[][] trailMap = {
            {3, 5, 6},
            {4, 7, 8},
            {1, 2, 9}
    };

    private final int[][] trailMap2 = {
            {1, 2, 3},
            {2, 3, 4},
            {3, 5, 6}
    };

    @Test
    void findPeakAltitude() {
        for (var i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                assertEquals(9, MountainPeak.findPeakAltitude(new int[][]{
                        {1, 2, 3},
                        {2, 5, 7},
                        {4, 6, 9}
                }, i, j), String.format("Not matched! for row %d %d", i, j));
            }
        }

    }

    @Test
    void findNextPeak() {

        int[] startPosition = {1, 1}; // Starting elevation
        int[] nextPeak = MountainPeak.findNextPeak(trailMap, startPosition[0], startPosition[1]);
        assertArrayEquals(new int[]{1, 2}, nextPeak, "Next peak coordinates should be (1, 2)");
    }

    @Test
    void trekPath() {
        var elevationPath = MountainPeak.trekPath(trailMap,1,1);
        assertAll(()-> assertNotNull(elevationPath),
                () -> assertEquals(3, elevationPath.size()),
                () -> assertEquals(7, elevationPath.getFirst()),
                () -> assertEquals(8, elevationPath.get(1)),
                () -> assertEquals(9, elevationPath.getLast()));
    }

    @Test
    void trekPath2() {
        var elevationPath = MountainPeak.trekPath(trailMap2,1,1);
        assertAll(()-> assertNotNull(elevationPath),
                () -> assertEquals(3, elevationPath.size()),
                () -> assertEquals(3, elevationPath.getFirst()),
                () -> assertEquals(5, elevationPath.get(1)),
                () -> assertEquals(6, elevationPath.getLast()));
    }
}