package org.own.util;

public class TimeUtil {
    /**
     * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
     * <p>
     * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
     * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
     * <p>
     * Example
     * <p>
     * Return '12:01:00'.
     * <p>
     * Return '00:01:00'.
     * <p>
     * Function Description
     * <p>
     * Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.
     * <p>
     * timeConversion has the following parameter(s):
     * <p>
     * string s: a time in hour format
     * <p>
     * Returns
     * <p>
     * string: the time in hour format
     * <p>
     * Input Format
     * <p>
     * A single string that represents a time in -hour clock format (i.e.: or ).
     * <p>
     * Constraints
     * <p>
     * All input times are valid
     * <p>
     * Sample Input
     * <p>
     * 07:05:45PM
     * <p>
     * Sample Output
     * <p>
     * 19:05:45
     *
     * @param s time in AM/ PM format.
     * @return  24 hour format time.
     */
    public static String timeConversion(String s) {
        // Write your code here
        // Extract AM/PM
        String period = s.substring(s.length() - 2);

        // Split the time part (HH:MM:SS)
        String[] timeParts = s.substring(0, s.length() - 2).split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);
        int second = Integer.parseInt(timeParts[2]);

        // Convert hour based on period
        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0; // 12:00:00 AM becomes 00:00:00
            }
        } else { // PM
            if (hour != 12) {
                hour += 12; // 1:00:00 PM becomes 13:00:00, etc.
            }
        }

        // Format hour with leading zero and return the 24-hour time string
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }



}


