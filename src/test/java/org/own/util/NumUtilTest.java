package org.own.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumUtilTest {

    @Test
    void countResponseTimeRegressions() {
        assertEquals(2, NumUtil.countResponseTimeRegressions(List.of(100, 200, 150, 300)));
        assertEquals(2, NumUtil.countResponseTimeRegressions(List.of(100, 150, 200, 300)));
    }

    @Test
    void removeElement() {
        assertEquals(2, NumUtil.removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    @Test
    void countSubMatrices() {
        assertEquals(4, NumUtil.countSubMatrices(new int[][]{{7, 6, 3}, {8, 6, 1}}, 18));
        assertEquals(6, NumUtil.countSubMatrices(new int[][]{{7, 2, 9}, {1, 5, 0}, {2, 6, 6}}, 20));
    }

    @Test
    void removeDuplicates() {
        assertEquals(2, NumUtil.removeDuplicates(new int[]{1, 1, 2}));
    }

    @Test
    void maxSubArray() {
        assertEquals(6, NumUtil.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(13, NumUtil.maxSubArray(new int[]{1, 2, 3, -4, 5, 6}));
        assertEquals(-1, NumUtil.maxSubArray(new int[]{-1, -2, -3, -4, -5}));
        assertEquals(15, NumUtil.maxSubArray(new int[]{1, 2, 3, 4, 5}));
        assertEquals(1, NumUtil.maxSubArray(new int[]{1, -1, 1, -1, 1}));
    }

    @Test
    void discountedPrice() {
        var result = NumUtil.discountedPrice(new int[]{2, 3, 1, 2, 4, 2});
        System.out.println(result);
        assertAll(() -> assertEquals(2, result.size(), "Result must have two entries total discounted price and full indexes"));
    }

    @Test
    void getNextMaxIndex() {
        assertEquals(1, NumUtil.getNextMaxIndex(new int[]{3, 2, 2, 3}, 0));
        assertEquals(2, NumUtil.getNextMaxIndex(new int[]{3, 2, 2, 3}, 2));
        assertEquals(2, NumUtil.getNextMaxIndex(new int[]{2, 3, 1, 2, 4, 2}, 0));
        assertEquals(5, NumUtil.getNextMaxIndex(new int[]{2, 3, 1, 2, 4, 2}, 3));
    }
}