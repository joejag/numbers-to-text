package com.joejag.numbertotext.dictionary.british;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BritishEnglishNumberDictionaryTest {

    private BritishEnglishNumberDictionary dictionary = new BritishEnglishNumberDictionary();

    @Test
    public void try_basic_numbers() {
        assertEquals("one", dictionary.wordFor(1));
        assertEquals("ten", dictionary.wordFor(10));
        assertEquals("one hundred", dictionary.wordFor(100));
        assertEquals("nine hundred", dictionary.wordFor(900));

    }

}
