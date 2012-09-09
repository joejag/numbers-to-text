package com.joejag.numbertotext.dictionary.british;

import com.joejag.numbertotext.breaker.Part;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BritishEnglishNumberDictionaryTest {

    private BritishEnglishNumberDictionary dictionary = new BritishEnglishNumberDictionary();

    @Test
    public void try_basic_numbers() {
        assertEquals("one", dictionary.wordFor(1));
        assertEquals("ten", dictionary.wordFor(10));
        assertEquals("one hundred", dictionary.wordFor(100));
        assertEquals("nine hundred", dictionary.wordFor(900));
    }

    @Test
    public void ensure_values_are_descending() {
        List<Integer> descendingNumbers = dictionary.getListOfDescendingNumbers();
        int previous = descendingNumbers.get(0);
        for (int number : descendingNumbers) {
            assertTrue(number <= previous);
            previous = number;
        }
    }

    @Test
    public void ensure_three_parts_are_included() {
        List<Part> parts = dictionary.parts();
        assertEquals(3, parts.size());
    }

    @Test
    public void ensure_parts_have_a_gap_of_three() {
        List<Part> parts = dictionary.parts();
        for (Part part : parts) {
            assertEquals(3, part.startIndexInNumber - part.endIndexInNumber);
        }
    }

    @Test
    public void valid_range_values() {
        // TODO: Write this!!
    }
}
