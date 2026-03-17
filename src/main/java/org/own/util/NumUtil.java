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


}

