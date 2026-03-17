package org.own.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumUtilTest {

    @Test
    void countResponseTimeRegressions() {
        assertEquals(2,NumUtil.countResponseTimeRegressions(List.of(100,200,150,300)));
        assertEquals(2,NumUtil.countResponseTimeRegressions(List.of(100,150,200,300)));
    }
}