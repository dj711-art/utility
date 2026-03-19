package org.own.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void countLetterFrequency() {
        var result = StringUtil.countLetterFrequency("the quick brown fox jumps over the lazy dog");
        assertNotNull(result);
        assertEquals(2, result.get('t'));
        assertEquals(2, result.get('h'));
        assertNull(result.get(' '));
    }
}