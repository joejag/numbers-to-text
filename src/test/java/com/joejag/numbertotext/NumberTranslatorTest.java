package com.joejag.numbertotext;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberTranslatorTest {

    @Test
    public void translate_1_to_one() {
        assertEquals("one", new NumberTranslator().translate(1));
    }

    @Test
    public void translate_2_to_two() {
        assertEquals("two", new NumberTranslator().translate(2));
    }


}
