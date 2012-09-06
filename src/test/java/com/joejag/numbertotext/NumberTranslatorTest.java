package com.joejag.numbertotext;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberTranslatorTest {

    @Test
    public void convert1ToOne() {
        assertEquals("one", new NumberTranslator().translate(1));
    }
}
