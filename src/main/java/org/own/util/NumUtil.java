package org.own.util;

import java.util.ArrayList;
import java.util.Collections;
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
     *
     * @param nums integer array.
     * @param val  integer value to be removed from the array.
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
     *
     * @param grid 0-indexed integer matrix grid.
     * @param k    integer.
     * @return the number of that contain the top-left element of the grid, and have a sum less than or equal to k.
     */
    public static int countSubMatrices(int[][] grid, int k) {
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

    /**
     *
     * @param nums integer array.
     * @return array length after removing duplicates in-place such that each element appears only once.
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int writePointer = 1;

        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            if (nums[readPointer] != nums[readPointer - 1]) {
                nums[writePointer] = nums[readPointer];
                writePointer++;
            }
        }

        return writePointer;
    }


    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        var max = nums[0];
        var curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(max, curr);
        }
        return max;
    }

    /**
     * You are provided with integer array prices. Price will be discounted by the next smaller element to the right of the current element.
     * If there is no smaller element to the right, then there is no discount for that element.
     *
     * @param prices integer array of prices.
     * @return total discount price as the first element of the array. Second element will be space separated index of the prices without any discount.
     */
    public static List<String> discountedPrice(int[] prices) {
        List<String> result = new ArrayList<>();
        var minIndex = getNextMaxIndex(prices, 0);
        var discountPrice = 0;
        List<Integer> fullPriceIndexes = new ArrayList<>();

        for (var index = 0; index < minIndex; index++) {
            discountPrice += (prices[index] - prices[minIndex]);
        }

        var nextMinIndex = getNextMaxIndex(prices, minIndex);
        for (var index = minIndex; index < prices.length; index++) {
            if (index > nextMinIndex) {
                nextMinIndex = getNextMaxIndex(prices, index);
            }
            if (nextMinIndex == index) {
                discountPrice += prices[nextMinIndex];
                fullPriceIndexes.add(index);
            } else {
                discountPrice += prices[index] - prices[nextMinIndex];
            }

        }

        result.add(String.valueOf(discountPrice));
        Collections.sort(fullPriceIndexes);
        StringBuilder sb = new StringBuilder();
        for (var index = 0; index < fullPriceIndexes.size(); index++) {
            sb.append(fullPriceIndexes.get(index));
            if (index != fullPriceIndexes.size() - 1) {
                sb.append(" ");
            }
        }
        result.add(sb.toString());
        return result;
    }

    public static int getNextMaxIndex(int[] prices, int i) {
        var minPrice = prices[i];
        var minIndex = i;
        for (int j = i + 1; j < prices.length; j++) {
            if (prices[j] < minPrice) {
                return j;
            } else if (prices[j] == minPrice) {
                minIndex = j;
            }
        }
        return minIndex;
    }

}

