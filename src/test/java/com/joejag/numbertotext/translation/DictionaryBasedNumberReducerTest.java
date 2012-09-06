package com.joejag.numbertotext.translation;

import com.joejag.numbertotext.dictionary.NumberDictionary;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DictionaryBasedNumberReducerTest {

    @Mock
    NumberDictionary dictionary;

    @Test
    public void single_word_available_then_return_single_element() {
        when(dictionary.getListOfDescendingNumbers()).thenReturn(Arrays.asList(1));
        when(dictionary.wordFor(1)).thenReturn("1");
        Assert.assertEquals(Arrays.asList("1"), new DictionaryBasedNumberReducer(dictionary).reduce(1));
    }

    @Test
    public void two_words_available_then_return_single_element_if_unused() {
        when(dictionary.getListOfDescendingNumbers()).thenReturn(Arrays.asList(2, 1));
        when(dictionary.wordFor(1)).thenReturn("1");
        assertEquals(Arrays.asList("1"), new DictionaryBasedNumberReducer(dictionary).reduce(1));
    }

    @Test
    public void two_words_available_then_return_two_elements_if_both_used() {
        when(dictionary.getListOfDescendingNumbers()).thenReturn(Arrays.asList(20, 1));
        when(dictionary.wordFor(20)).thenReturn("2");
        when(dictionary.wordFor(1)).thenReturn("1");
        assertEquals(Arrays.asList("2", "1"), new DictionaryBasedNumberReducer(dictionary).reduce(21));
    }

    // number higher ignored

    // number lower ignored

}
