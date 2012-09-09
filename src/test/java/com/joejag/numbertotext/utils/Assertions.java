package com.joejag.numbertotext.utils;

import com.joejag.numbertotext.NumberToTextMain;

import static org.junit.Assert.assertEquals;

public class Assertions {

    public static void assertConversion(String expected, int input) {
        assertEquals(expected, new NumberToTextMain().translateToBritishEnglish(input));
    }
}
