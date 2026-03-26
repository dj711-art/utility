package org.own.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeUtilTest {

    @Test
    void timeConversion() {
        for (var hour = 0; hour < 12; hour++) {
            var time = String.format("%02d:00:00AM", hour);
            var expectedHour = hour == 0 ? "00" : String.format("%02d", hour);
            var expectedTime = String.format("%s:00:00", expectedHour);
            assertEquals(expectedTime, TimeUtil.timeConversion(time));
        }
        // similarly for PM
        for (var hour = 0; hour <= 12; hour++) {
            var time = String.format("%02d:00:00PM", hour);
            var expectedHour = hour == 12 ? "12" : String.format("%02d", hour+12);
            var expectedTime = String.format("%s:00:00", expectedHour);
            assertEquals(expectedTime, TimeUtil.timeConversion(time));
        }



    }
}