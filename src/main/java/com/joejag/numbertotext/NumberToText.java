package com.joejag.numbertotext;

import java.util.List;

public class NumberToText {

    private NumberTranslator numberTranslator = new NumberTranslator();
    private NumberReducer numberReducer = new NumberReducer(new BritishEnglishNumberDictionary());

    public String translate(int input) {
        List<String> reduced = numberReducer.reduce(input);
        return numberTranslator.translate(reduced);
    }
}
