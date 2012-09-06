package com.joejag.numbertotext.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringPadderTest {

    @Test
    public void already_correct_length_string_is_not_padded() {
        String paddedVersion = StringPadder.padLeft("abc", "-", 0);
        assertEquals("abc", paddedVersion);
    }

    @Test
    public void string_is_left_padded() {
        String paddedVersion = StringPadder.padLeft("abc", "-", 6);
        assertEquals("---abc", paddedVersion);
    }


}
