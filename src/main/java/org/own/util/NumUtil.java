package org.own.util;

import java.util.List;

public class NumUtil {
    /**
     * Given an array of positive integers, return the number of elements that are strictly greater than the average of
     * all previous elements. Skip the first element.
     *
     * @param responseTimes - integer array.
     * @return number of elements that are strictly greater than the average of all previous elements.
     */
    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
        // Write your code here
        var count = 0;
        if (responseTimes != null && !responseTimes.isEmpty()) {
            var size = responseTimes.size();
            var prefixAvg = new double[size];
            for (var index = 0; index < size; index++) {
                var current = responseTimes.get(index);
                if (index > 0) {
                    if (current > prefixAvg[index - 1]) {
                        System.out.println(current + " greater than previous avg");
                        count++;
                    }
                    prefixAvg[index] = ((prefixAvg[index - 1] + current) / index);
                } else {
                    prefixAvg[index] = current;
                }
            }
        }
        return count;
    }

    /**
     * From the given integer array nums, remove all occurrences of val from nums in-place.
     * @param nums integer array.
     * @param val integer value to be removed from the array.
     * @return length of the new array.
     */
    public static int removeElement(int[] nums, int val) {

        var size = nums.length;
        var endIndex = size - 1;
        var count = size;

        for (var index = 0; index <= endIndex; index++) {
            if (nums[index] == val) {
                while (endIndex > index && nums[endIndex] == val) {
                    endIndex--;
                    count--;
                }
                if (index < endIndex) {
                    nums[index] = nums[endIndex];
                    endIndex--;
                    count--;
                }
            }
        }

        return count;
    }

    /**
     * You are given a 0-indexed integer matrix grid and an integer k.
     * <p>
     * Return the number of that contain the top-left element of the grid, and have a sum less than or equal to k.
     * @param grid 0-indexed integer matrix grid.
     * @param k integer.
     * @return the number of that contain the top-left element of the grid, and have a sum less than or equal to k.
     */
    public static int countSubMatrices(int[][] grid,int k){
        var count = 0;
        var rows = grid.length;
        var cols = grid[0].length;
        var prefixSum = new int[rows][cols];
        for (var row = 0; row < rows; row++) {
            for (var col = 0; col < cols; col++) {
                prefixSum[row][col] = grid[row][col];
                if (row > 0) {
                    prefixSum[row][col] += prefixSum[row - 1][col];
                }
                if (col > 0) {
                    prefixSum[row][col] += prefixSum[row][col - 1];
                }
                if (row > 0 && col > 0) {
                    prefixSum[row][col] -= prefixSum[row - 1][col - 1];

                }
                if (prefixSum[row][col] <= k) {
                    count++;
                }
            }
        }
        return count;
    }

}

