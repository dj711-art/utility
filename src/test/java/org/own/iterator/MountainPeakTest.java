package org.own.iterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainPeakTest {

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

    @org.junit.jupiter.api.Test
    void findNextPeak() {
        int[][] trailMap = {
                {3, 5, 6},
                {4, 7, 8},
                {1, 2, 9}
        };
        int[] startPosition = {1, 1}; // Starting elevation
        int[] nextPeak = MountainPeak.findNextPeak(trailMap, startPosition[0], startPosition[1]);
        assertArrayEquals(new int[]{1, 2}, nextPeak, "Next peak coordinates should be (1, 2)");
    }
}