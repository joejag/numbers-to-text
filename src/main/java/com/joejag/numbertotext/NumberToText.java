package com.joejag.numbertotext;

public class NumberToText {

    private NumberTranslator numberTranslator = new NumberTranslator(new BritishEnglishNumberDictionary());

    public String translate(int input) {
        return numberTranslator.translate(input);
    }
}
