package org.own.iterator;

public class BinaryGap {
    /**
     * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
     * <p>
     * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
     *
     * @param N an integer.
     * @return maximum binary gap
     */
    public int solution(int N) {
        // Implement your solution here
        var maxGap = 0;
        var current = 0;
        var started = false;
        while (N > 0) {
            if (N % 2 == 1) {
                if (started) {
                    maxGap = Math.max(maxGap, current);
                    current = 0;
                }
                started = true;
            } else {
                if (started) {
                    current++;
                }
            }
            N /= 2;
        }

        return maxGap;
    }
}
