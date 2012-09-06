package com.joejag.numbertotext;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberConvertorTest {

    @Test
    public void convert1ToOne() {
        assertEquals("one", new NumberConvertor().convert(1));
    }
}
