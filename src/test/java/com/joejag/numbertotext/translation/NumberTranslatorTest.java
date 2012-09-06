package com.joejag.numbertotext.translation;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NumberTranslatorTest {

    private NumberTranslator numberTranslator = new NumberTranslator();

    @Test
    public void single_element_is_returned_alone() {
        assertEquals("one", numberTranslator.translate(Arrays.asList("one")));
    }

    @Test
    public void two_elements_are_joined_with_a_space() {
        assertEquals("twenty two", numberTranslator.translate(Arrays.asList("twenty", "two")));
    }
}
