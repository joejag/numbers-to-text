package com.joejag.numbertotext;

import com.joejag.numbertotext.dictionary.BritishEnglishNumberDictionary;
import com.joejag.numbertotext.translation.DictionaryBasedNumberReducer;
import com.joejag.numbertotext.translation.NumberTranslator;

import java.util.List;

public class NumberToText {

    private DictionaryBasedNumberReducer numberReducer = new DictionaryBasedNumberReducer(new BritishEnglishNumberDictionary());

    public String translate(int input) {
        List<String> reduced = numberReducer.reduce(input);
        return new NumberTranslator().translate(reduced);
    }
}
