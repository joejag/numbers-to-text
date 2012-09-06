package com.joejag.numbertotext;

import java.util.ArrayList;
import java.util.List;

public class NumberReducer {

    private NumberDictionary dictionary;

    public NumberReducer(NumberDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> reduce(int number) {
        List<String> tokens = new ArrayList<String>();

        int remainder = number;

        for (int integer : dictionary.getListOfDescendingNumbers()) {
            if (remainder >= integer) {
                tokens.add(dictionary.wordFor(integer));
                remainder -= integer;
            }
        }

        return tokens;
    }
}
