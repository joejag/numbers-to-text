package com.joejag.numbertotext;

import com.joejag.numbertotext.dictionary.BritishEnglishNumberDictionary;
import com.joejag.numbertotext.translation.NumberReducer;
import com.joejag.numbertotext.translation.NumberTranslator;

import java.util.List;

public class NumberToText {

    private NumberReducer numberReducer = new NumberReducer(new BritishEnglishNumberDictionary());

    public String translate(int input) {
        List<String> reduced = numberReducer.reduce(input);
        return new NumberTranslator().translate(reduced);
    }
}
