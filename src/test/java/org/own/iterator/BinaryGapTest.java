package org.own.iterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryGapTest {

    BinaryGap binaryGap = new BinaryGap();

    @Test
    void solution() {
        assertEquals(0,binaryGap.solution(1));
        assertEquals(0,binaryGap.solution(3));
        assertEquals(1,binaryGap.solution(5));
        assertEquals(0,binaryGap.solution(Integer.MAX_VALUE));
    }
}