package com.joejag.numbertotext.translation;

import org.junit.Test;

import static com.joejag.numbertotext.breaker.NumberComponent.Part.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class NumberTranslatorTest {

    private NumberTranslator numberTranslator = new NumberTranslator();

    @Test
    public void single_element_is_returned_alone() {
        assertEquals("one", numberTranslator.translate(asList("one"), HUNDRED));
    }

    @Test
    public void two_elements_are_joined_with_a_space() {
        assertEquals("twenty two", numberTranslator.translate(asList("twenty", "two"), HUNDRED));
    }

    @Test
    public void hundreds_are_given_an_and_if_more_words_to_come() {
        assertEquals("one hundred and twenty two", numberTranslator.translate(asList("one hundred", "twenty", "two"), HUNDRED));
    }

    @Test
    public void hundreds_arent_given_an_and_if_no_more_words_to_come() {
        assertEquals("one hundred", numberTranslator.translate(asList("one hundred"), HUNDRED));
    }

    @Test
    public void when_in_thousands_a_word_is_appended() {
        assertEquals("one hundred thousand", numberTranslator.translate(asList("one hundred"), THOUSAND));
    }

    @Test
    public void when_in_millions_a_word_is_appended() {
        assertEquals("one hundred million", numberTranslator.translate(asList("one hundred"), MILLION));
    }

    @Test
    public void when_in_thousands_a_word_is_appended_at_the_end() {
        assertEquals("one hundred and five thousand", numberTranslator.translate(asList("one hundred", "five"), THOUSAND));
    }
}
